package com.bonvino.boundary;

import com.bonvino.controller.GestorGenerarReporteRankingVino;
import com.bonvino.dto.GenerarReporteRankingVinoRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reportes")
public class PantallaGenerarReporteRankingVino {

    // Constructor de la pantalla y relacion con el gestor
    private final GestorGenerarReporteRankingVino gestor;
    
    @Autowired
    public PantallaGenerarReporteRankingVino(GestorGenerarReporteRankingVino gestor) {
        this.gestor = gestor;
        this.gestor.setPantalla(this); // Pasarse a sí misma como parámetro al gestor
    }

    // Post de comunicacion entre la pantalla backend y el frontend
    @PostMapping("/generar-ranking-de-vinos")
    public Object opcionGenerarRankingDeVinos(@RequestBody GenerarReporteRankingVinoRequest request) {
        gestor.opcionGenerarRankingVino(request);
        return "Reporte generado";
    }

    // Metodos de comunicacion entre la pantalla y el gestor para pasar los datos
    public void solicitarSeleccionFechasInicioFin(GenerarReporteRankingVinoRequest request) {
        this.gestor.tomarSeleccionFechasInicioFin(request.getFechaInicio(), request.getFechaFin());
    }
    public void mostrarYSolicitarTipoReporte(GenerarReporteRankingVinoRequest request) {
        this.gestor.tomarSeleccionTipoReporte(request.getTipoReporteSeleccionado());
    }  
    public void solicitarConfirmacionReporte(GenerarReporteRankingVinoRequest request) {
        this.gestor.tomarConfirmacionReporte(request.getConfirmacionReporte());
    }

}
