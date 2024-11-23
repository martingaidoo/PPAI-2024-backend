package com.bonvino.dto;

public class GenerarReporteRankingVinoRequest {
    private String fechaInicio;
    private String fechaFin;
    private String tipoReporteSeleccionado;

    public String getFechaInicio() {
        return this.fechaInicio;
    }

    public String getFechaFin() {
        return this.fechaFin;
    }

    public String getTipoReporteSeleccionado() {
        return this.tipoReporteSeleccionado;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setTipoReporteSeleccionado(String tipoReporteSeleccionado) {
        this.tipoReporteSeleccionado = tipoReporteSeleccionado;
    }

}