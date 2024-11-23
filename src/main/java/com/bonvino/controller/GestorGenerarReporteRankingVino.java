package com.bonvino.controller;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class GestorGenerarReporteRankingVino {
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

    public void getTipoReporteSeleccionado() {
        // Método vacío
    }

    public String tomarSeleccionTipoReporte(String fechaInicio, String fechaFin, String tipoReporteSeleccionado) {
        return "Reporte generado";
    }

    public void buscarVinosConReseñasPorTipoYEnFecha() {
        // Método vacío
    }

}
