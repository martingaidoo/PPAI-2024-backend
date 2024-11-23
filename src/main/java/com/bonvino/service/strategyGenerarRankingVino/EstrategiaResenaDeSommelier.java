package com.bonvino.service.strategyGenerarRankingVino;

import java.util.List;
import org.springframework.stereotype.Service;

import com.bonvino.service.strategyGenerarRankingVino.IEstrategia;
import com.bonvino.model.Vino;

@Service
public class EstrategiaResenaDeSommelier implements IEstrategia {

    private String fechaInicio;
    private String fechaFin;
    private List<String> tiposReportes;
    private String tipoReporteSeleccionado;
    private String tipoVisualizacion;
    private String tipoVisualizacionSeleccionada;
    private Boolean confirmacionReporte;
    private List<String> vinosFiltradosPorReseña;
    private List<String> vinosFiltradosPorReseñaConPromedio;
    private List<String> vinosRankeados;
    private List<String> vinosRanking10;
    private List<String> datosVinosRankeados;

    public void tomarFormaVisualizacionReporte() {
        // Método vacío
    }

    public void tomarConfirmacionReporte() {
        // Método vacío
    }

    public float[] calcularCalificacionesPromedio(String fecha) {
        return new float[] { 2.2145f, 0.24f };
    }

    public void getTipoReporteSeleccionado() {
        // Método vacío
    }

    public String tomarSeleccionTipoReporte(String fechaInicio, String fechaFin, String tipoReporteSeleccionado) {
        return "Reporte generado";
    }

    public Vino[] buscarVinosConReseñasPorTipoYEnFecha(String fecha) {
        return new Vino[] { new Vino(), new Vino() };
    }

}
