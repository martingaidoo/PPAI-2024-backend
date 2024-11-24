package com.bonvino.dto;

public class GenerarReporteRankingVinoRequest {
    private String fechaInicio;
    private String fechaFin;
    private String tipoReporteSeleccionado;
    private Boolean confirmacionReporte;

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

    public Boolean getConfirmacionReporte() {
        return this.confirmacionReporte;
    }

    public void setConfirmacionReporte(Boolean confirmacionReporte) {
        this.confirmacionReporte = confirmacionReporte;
    }

}