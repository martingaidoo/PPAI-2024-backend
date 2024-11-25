package com.bonvino.controller;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Comparator;

import com.bonvino.boundary.PantallaGenerarReporteRankingVino;
import com.bonvino.boundary.GeneradorArchivoExcel;
import com.bonvino.dto.GenerarReporteRankingVinoRequest;
import com.bonvino.service.strategyGenerarRankingVino.EstrategiaResenaDeAmigos;
import com.bonvino.service.strategyGenerarRankingVino.EstrategiaResenaDeSommelier;
import com.bonvino.service.strategyGenerarRankingVino.EstrategiaResenaNormal;
import com.bonvino.service.strategyGenerarRankingVino.IEstrategia;
import com.bonvino.model.Vino;
import com.bonvino.repository.RepositoryVino;

import java.io.IOException;

@RestController
@RequestMapping("/api")
public class GestorGenerarReporteRankingVino {

    private final GeneradorArchivoExcel generadorArchivoExcel;
    private final RepositoryVino repositoryVino;

    // Inyección del repositorio y del generador de archivos por constructor
    @Autowired
    public GestorGenerarReporteRankingVino(GeneradorArchivoExcel generadorArchivoExcel, RepositoryVino repositoryVino) {
        this.generadorArchivoExcel = generadorArchivoExcel;
        this.repositoryVino = repositoryVino;
    }

    // Atributos del request
    private Date fechaInicio;
    private Date fechaFin;
    private String tipoReporteSeleccionado;
    private String tipoVisualizacionSeleccionada;

    // Atributos de opciones predefinidas
    private List<String> tiposReportes;
    private List<String> formasVisualizacion;

    // Atributos de vinos filtrados y rankeados
    private List<Vino> todosLosVinos;
    private List<Vino> vinosFiltradosPorResena;
    private Object[] vinosFiltradosPorResenaConPromedio;
    private Object[] vinosRankeados;
    private Object[] vinosRanking10;
    private String[][] datosVinosRankeados;

    // Atributo puntero a la estrategia elegida
    private IEstrategia estrategiaElegida;

    @PostMapping("/generar-ranking-de-vinos")
    public ResponseEntity<byte[]> opcionGenerarRankingVino(@RequestBody GenerarReporteRankingVinoRequest request) {
        try {
            this.todosLosVinos = repositoryVino.findAll();
            System.out.println("Todos los vinos: " + this.todosLosVinos);
            tomarSeleccionFechasInicioFin(request.getFechaInicio(), request.getFechaFin());
            tomarSeleccionTipoReporte(request.getTipoReporteSeleccionado());
            tomarFormaVisualizacionReporte(request.getTipoVisualizacionSeleccionada());
            tomarConfirmacionReporte(request.getConfirmacionReporte());
            return ResponseEntity.ok()
                    .contentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM)
                    .body(this.generarArchivoExcel(datosVinosRankeados));

        } catch (Exception e) {
            e.printStackTrace();
            // En caso de error, devolver un código HTTP 500
            return ResponseEntity.status(500).body(null);
        }

    }

    public void tomarSeleccionTipoReporte(String tipoReporteSeleccionado) {
        this.tipoReporteSeleccionado = tipoReporteSeleccionado;
        this.estrategiaElegida = crearEstrategia();
    }

    public void tomarFormaVisualizacionReporte(String tipoVisualizacionSeleccionada) {
        this.tipoVisualizacionSeleccionada = tipoVisualizacionSeleccionada;
    }

    public void tomarSeleccionFechasInicioFin(String fechaInicio, String fechaFin) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            this.fechaInicio = dateFormat.parse(fechaInicio);
            this.fechaFin = dateFormat.parse(fechaFin);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }

    public void tomarConfirmacionReporte(Boolean confirmacionReporte) {
        this.vinosFiltradosPorResena = this.buscarvinosFiltradosPorResenasPorTipoYEnFecha();
        this.vinosFiltradosPorResenaConPromedio = this.calcularCalificacionesPromedio();
        this.vinosRankeados = this.ordenarVinosPorRanking();
        this.vinosRanking10 = this.tomar10PrimerosVinosCalificados();
        this.datosVinosRankeados = this.buscarDatos10MejoresVinos();
        switch (this.tipoVisualizacionSeleccionada) {
            case "PDF":
                // Forma de visualizacion no implementada
                break;
            case "Excel":
                this.generarArchivoExcel(this.datosVinosRankeados);
                break;
            case "Por pantalla":
                // Forma de visualizacion no implementada
                break;
            default:
                throw new IllegalArgumentException("Tipo de reporte no válido: " + tipoReporteSeleccionado);
        }
    }

    // Metodos de creacion y delegacion entre el gestor y la estrategia
    public IEstrategia crearEstrategia() {
        switch (this.tipoReporteSeleccionado) {
            case "Resena de amigos":
                this.estrategiaElegida = new EstrategiaResenaDeAmigos();
                break;
            case "Resena de sommelier":
                this.estrategiaElegida = new EstrategiaResenaDeSommelier();
                break;
            case "Resena normal":
                this.estrategiaElegida = new EstrategiaResenaNormal();
                break;
            default:
                throw new IllegalArgumentException("Tipo de reporte no válido: " + tipoReporteSeleccionado);
        }
        return this.estrategiaElegida;
    }

    public List<Vino> buscarvinosFiltradosPorResenasPorTipoYEnFecha() {

        return this.estrategiaElegida.buscarvinosFiltradosPorResenasPorTipoYEnFecha(
                this.fechaInicio,
                this.fechaFin, this.todosLosVinos);

    }

    public Object[] calcularCalificacionesPromedio() {
        return this.estrategiaElegida
                .calcularCalificacionesPromedio(this.fechaInicio, this.fechaFin, this.vinosFiltradosPorResena);
    }

    // ** Este metodo deberia recibir un array de vinos con sus calificaciones
    // promedio y ordenarlos por ranking
    public Object[] ordenarVinosPorRanking() {

        
        // Imprimir el contenido de vinosRanking antes de ordenar

        vinosRankeados = this.vinosFiltradosPorResenaConPromedio;
        if (vinosRankeados == null || vinosRankeados.length == 0) {
            throw new IllegalStateException("No hay vinos rankeados disponibles para tomar los 10 primeros");
        }
        Arrays.sort(vinosRankeados, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                Object[] vino1 = (Object[]) o1;
                Object[] vino2 = (Object[]) o2;
                float ranking1 = (float) vino1[1];
                float ranking2 = (float) vino2[1];
                return Float.compare(ranking1, ranking2);
            }
        });
        return vinosRankeados;
    }

    public Object[] tomar10PrimerosVinosCalificados() {
        this.vinosRanking10 = new Object[10];
        for (int i = 0; i < 10; i++) {
            this.vinosRanking10[i] = this.vinosRankeados[i];
        }
        if (vinosRanking10 == null || vinosRanking10.length < 10) {
            throw new IllegalStateException("No hay suficientes vinos rankeados para tomar los 10 primeros");
        }
        return vinosRanking10;
    }

    public String[][] buscarDatos10MejoresVinos() {
        // Verificar que vinosRanking10 no esté vacío y tenga al menos 10 elementos
        

        // Determinar el tamaño de la matriz de salida
        int size = Math.min(this.vinosRanking10.length, 10);
        String[][] datosVinosRankeados = new String[size][8];

        for (int i = 0; i < size; i++) {
            Object[] vinoConRanking = (Object[]) this.vinosRanking10[i];
            Vino vinoRanking = (Vino) vinoConRanking[0];
            float ranking = (float) vinoConRanking[1];
            String[] datosBodega = vinoRanking.obtenerBodega();
            String[] datosVarietal = vinoRanking.obtenerVarietal();
            float precioVino = vinoRanking.getPrecioARS();
            String nombre = vinoRanking.getNombre();
            float calificacionGeneral = vinoRanking.getCalificacionGeneral();

            // Asegurarse de que datosVarietal y datosBodega tengan suficientes elementos
            String bodega = datosBodega[0];
            String region = datosBodega[1];
            String pais = datosBodega[3];
            String varietal = String.join(" - ", datosVarietal);

            datosVinosRankeados[i] = new String[] {
                    nombre,
                    String.valueOf(ranking),
                    String.valueOf(calificacionGeneral),
                    String.valueOf(precioVino),
                    bodega,
                    varietal,
                    region,
                    pais
            };
        }

        // Este es el orden de los encabezados
        // "Nombre", "Calificación Sommelier", "Calificación General", "Precio ARS",
        // "Bodega", "Varietal", "Región", "País"
        return datosVinosRankeados;
    }

    public byte[] generarArchivoExcel(String[][] datosVinosRankeados) {
        try {
            return this.generadorArchivoExcel.generarArchivo(datosVinosRankeados);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed, e.g., return an empty byte array or rethrow
            // the exception
            return new byte[0];
        }
    }

    public void setEstrategiaElegida(IEstrategia estrategiaElegida) {
        this.estrategiaElegida = estrategiaElegida;
    }

    // borrar luego de pruebas
    public List<Vino> obtenerTodosLosVinos() {
        return this.repositoryVino.findAll();
    }
}
