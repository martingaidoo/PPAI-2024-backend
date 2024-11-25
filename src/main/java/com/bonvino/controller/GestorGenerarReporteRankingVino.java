package com.bonvino.controller;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

@Service
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
    private Boolean confirmacionReporte;

    // Atributos de opciones predefinidas
    private List<String> tiposReportes;
    private String tipoVisualizacion;
    private String tipoVisualizacionSeleccionada;

    // Atributos de vinos filtrados y rankeados
    private List<Vino> todosLosVinos;
    private List<Vino> vinosFiltradosPorResena;
    private List<Vino> vinosFiltradosPorReseñaConPromedio;
    private Object[] vinosRankeados;
    private Object[] vinosRanking10;
    private String[][] datosVinosRankeados;

    // Atributo puntero a la estrategia elegida
    private IEstrategia estrategiaElegida;

    // Atributo de comunicacion con la pantalla
    private PantallaGenerarReporteRankingVino pantalla;

    // Metodos de comunicacion entre el gestor y la pantalla para obtener los datos
    public void setPantalla(PantallaGenerarReporteRankingVino pantalla) {
        this.pantalla = pantalla;
    }

    public byte[] opcionGenerarRankingVino(GenerarReporteRankingVinoRequest request) {
        this.todosLosVinos = repositoryVino.findAll();
        this.pantalla.solicitarSeleccionFechasInicioFin(request);
        this.pantalla.mostrarYSolicitarTipoReporte(request);
        this.pantalla.solicitarConfirmacionReporte(request);
        return this.generarArchivoExcel(datosVinosRankeados);
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
            // Handle the exception as needed
        }
    }

    public void tomarConfirmacionReporte(Boolean confirmado) {
        this.confirmacionReporte = confirmado;
        if (this.confirmacionReporte) {
            this.buscarvinosFiltradosPorResenasPorTipoYEnFecha();
            Object[] calificacionesPromedioVino = this.calcularCalificacionesPromedio();
            this.vinosRankeados = this.ordenarVinosPorRanking(calificacionesPromedioVino);
            this.vinosRanking10 = this.tomar10PrimerosVinosCalificados(vinosRankeados);
            this.datosVinosRankeados = this.buscarDatos10MejoresVinos(vinosRanking10);
            this.generarArchivoExcel(this.datosVinosRankeados);
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

    public void buscarvinosFiltradosPorResenasPorTipoYEnFecha() {

        this.vinosFiltradosPorResena = this.estrategiaElegida.buscarvinosFiltradosPorResenasPorTipoYEnFecha(
                this.fechaInicio,
                this.fechaFin, this.todosLosVinos);

    }

    public Object[] calcularCalificacionesPromedio() {
        return this.estrategiaElegida.calcularCalificacionesPromedio(this.fechaInicio, this.fechaFin,
                this.vinosFiltradosPorResena);
    }

    // ** Este metodo deberia recibir un array de vinos con sus calificaciones
    //
    // promedio y ordenarlos por ranking
    public Object[] ordenarVinosPorRanking(Object[] vinosRanking) {
        if (vinosRanking == null || vinosRanking.length == 0) {
            throw new IllegalArgumentException("La lista de vinos a ordenar está vacía o es nula");
        }
        // Imprimir el contenido de vinosRanking antes de ordenar
        System.out.println("Contenido de vinosRanking antes de ordenar: " + Arrays.toString(vinosRanking));

        Arrays.sort(vinosRanking, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                Object[] vino1 = (Object[]) o1;
                Object[] vino2 = (Object[]) o2;
                float ranking1 = (float) vino1[1];
                float ranking2 = (float) vino2[1];
                return Float.compare(ranking1, ranking2);
            }
        });
        System.out.println("Vinos ordenados por ranking: " + Arrays.toString(vinosRanking));
        return vinosRanking;
    }

    public Object[] tomar10PrimerosVinosCalificados(Object[] vinosRanking) {
        this.vinosRanking10 = new Object[10];
        for (int i = 0; i < 10; i++) {
            this.vinosRanking10[i] = vinosRanking[i];
        }
        return vinosRanking10;
    }

    public String[][] buscarDatos10MejoresVinos(Object[] vinosRanking10) {
        // Verificar que vinosRanking10 no esté vacío y tenga al menos 10 elementos
        if (vinosRanking10 == null || vinosRanking10.length == 0) {
            throw new IllegalArgumentException("La lista de vinos rankeados está vacía o es nula");
        }

        // Determinar el tamaño de la matriz de salida
        int size = Math.min(vinosRanking10.length, 10);
        String[][] datosVinosRankeados = new String[size][8];

        for (int i = 0; i < size; i++) {
            Object[] vinoConRanking = (Object[]) vinosRanking10[i];
            Vino vinoRanking = (Vino) vinoConRanking[0];
            float ranking = (float) vinoConRanking[1];
            String[] datosBodega = vinoRanking.obtenerBodega();
            String[] datosVarietal = vinoRanking.obtenerVarietal();
            float precioVino = vinoRanking.getPrecioARS();
            String nombre = vinoRanking.getNombre();
            float calificacionGeneral = vinoRanking.getCalificacionGeneral();

            // Asegurarse de que datosVarietal y datosBodega tengan suficientes elementos
            String bodega = datosBodega.length > 0 ? datosBodega[0] : "N/A";
            String varietal1 = datosVarietal.length > 0 ? datosVarietal[0] : "N/A";
            String varietal2 = datosVarietal.length > 1 ? datosVarietal[1] : "N/A";
            String varietal3 = datosVarietal.length > 2 ? datosVarietal[2] : "N/A";

            datosVinosRankeados[i] = new String[]{
                nombre,
                String.valueOf(ranking),
                String.valueOf(calificacionGeneral),
                String.valueOf(precioVino),
                bodega,
                varietal1,
                varietal2,
                varietal3
            };
        }

        // Este es el orden de los encabezados
        // "Nombre", "Calificación Sommelier", "Calificación General", "Precio ARS",
        // "Bodega", "Varietal", "Región", "País"
        System.out.println("Datos de los 10 mejores vinos: " + Arrays.deepToString(datosVinosRankeados));
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
