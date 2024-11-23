package com.bonvino.controller;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class GestorGenerarReporteRankingVino {

    private final RepositoryVino repositoryVino;
    private final GeneradorArchivoExcel generadorArchivoExcel;

    // Inyección del repositorio por constructor
    public GestorGenerarReporteRankingVino(RepositoryVino repositoryVino) {
        this.repositoryVino = repositoryVino;
        this.generadorArchivoExcel = new GeneradorArchivoExcel();
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
    private Vino[] vinosFiltradosPorReseña;
    private Vino[] vinosFiltradosPorReseñaConPromedio;
    private Object[] vinosRankeados;
    private Object[] vinosRanking10;
    private String[][] datosVinosRankeados;
    private Vino[] vinosConReseña;

    // Atributo puntero a la estrategia elegida
    private IEstrategia estrategiaElegida;

    // Atributo de comunicacion con la pantalla
    private PantallaGenerarReporteRankingVino pantalla;

    // Metodos de comunicacion entre el gestor y la pantalla para obtener los datos
    public void setPantalla(PantallaGenerarReporteRankingVino pantalla) {
        this.pantalla = pantalla;
    }

    public byte[] opcionGenerarRankingVino(GenerarReporteRankingVinoRequest request) {
        this.pantalla.solicitarSeleccionFechasInicioFin(request);
        this.pantalla.mostrarYSolicitarTipoReporte(request);
        this.pantalla.solicitarConfirmacionReporte(request);
        return this.generarArchivoExcel(datosVinosRankeados);
    }

    public void tomarSeleccionTipoReporte(String tipoReporteSeleccionado) {
        this.estrategiaElegida = crearEstrategia();
    }

    public void tomarSeleccionFechasInicioFin(String fechaInicio, String fechaFin) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
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
            this.buscarVinosConReseñasPorTipoYEnFecha(this.fechaInicio, this.fechaFin);
            Object[] calificacionesPromedioVino = this.calcularCalificacionesPromedio();
            this.vinosRanking10 = this.ordenarVinosPorRanking(calificacionesPromedioVino);
            Object[] vinosRanking10Final = this.tomar10PrimerosVinosCalificados(vinosRanking10);
            this.generarArchivoExcel(this.buscarDatos10MejoresVinos(vinosRanking10Final));
        }
    }

    // Metodos de creacion y delegacion entre el gestor y la estrategia
    public IEstrategia crearEstrategia() {
        switch (this.tipoReporteSeleccionado) {
            case "Resena de amigos":
                this.estrategiaElegida = new EstrategiaResenaDeAmigos();
                break;
            case "Resena de sommelier":
                this.estrategiaElegida = new EstrategiaResenaDeSommelier(null);
                break;
            case "Resena normal":
                this.estrategiaElegida = new EstrategiaResenaNormal();
                break;
            default:
                throw new IllegalArgumentException("Tipo de reporte no válido: " + tipoReporteSeleccionado);
        }
        return this.estrategiaElegida;
    }

    public void buscarVinosConReseñasPorTipoYEnFecha(Date fechaInicio, Date fechaFin) {
        this.vinosConReseña = this.estrategiaElegida.buscarVinosConReseñasPorTipoYEnFecha(this.fechaInicio,
                this.fechaFin);
    }

    public Object[] calcularCalificacionesPromedio() {
        return this.estrategiaElegida.calcularCalificacionesPromedio(this.fechaInicio, this.fechaFin,
                this.vinosFiltradosPorReseña);
    }

    // ** Este metodo deberia recibir un array de vinos con sus calificaciones
    //
    // promedio y ordenarlos por ranking
    public Object[] ordenarVinosPorRanking(Object[] vinosRanking) {
        Arrays.sort(vinosRanking, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                Object[] vino1 = (Object[]) o1;
                Object[] vino2 = (Object[]) o2;
                Double ranking1 = (Double) vino1[1];
                Double ranking2 = (Double) vino2[1];
                return ranking1.compareTo(ranking2);
            }
        });
        return vinosRanking;
    }

    public Object[] tomar10PrimerosVinosCalificados(Object[] vinosRanking) {
        Object[] vinosRanking10 = new Object[10];
        for (int i = 0; i < 10; i++) {
            vinosRanking10[i] = vinosRanking[i];
        }
        return vinosRanking10;
    }

    public String[][] buscarDatos10MejoresVinos(Object[] vinosRanking10) {
        String[][] datosVinosRankeados = new String[10][6];
        for (int i = 0; i < vinosRanking10.length; i++) {
            Object[] vinoConRanking = (Object[]) vinosRanking10[i];
            Vino vinoRanking = (Vino) vinoConRanking[0];
            Double ranking = (Double) vinoConRanking[1];
            String[] datosBodega = vinoRanking.obtenerBodega();
            String[] datosVarietal = vinoRanking.obtenerVarietal();
            float precioVino = vinoRanking.getPrecioARS();
            String nombre = vinoRanking.getNombre();
            float calificacionGeneral = vinoRanking.getCalificacionGeneral();
            datosVinosRankeados[i] = new String[] { nombre, String.valueOf(ranking),

                    String.valueOf(calificacionGeneral),
                    String.valueOf(precioVino), datosBodega[0], datosVarietal[0], datosVarietal[1], datosVarietal[2] };
        }
        // Tiene que retornar la matriz 10 x 8
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

}
