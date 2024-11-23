package com.bonvino.boundary;

import com.bonvino.controller.GestorGenerarReporteRankingVino;
import com.bonvino.dto.GenerarReporteRankingVinoRequest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reportes")
public class PantallaGenerarReporteRankingVino {

    private final GestorGenerarReporteRankingVino gestor;

    // Inyección de dependencias por constructor
    public PantallaGenerarReporteRankingVino(GestorGenerarReporteRankingVino gestor) {
        this.gestor = gestor;
    }

    @PostMapping
    public String tomarSeleccionTipoReporte(@RequestBody GenerarReporteRankingVinoRequest request) {
        return gestor.tomarSeleccionTipoReporte(request.getFechaInicio(), request.getFechaFin(),request.getTipoReporteSeleccionado());
    }

    @GetMapping("/hello")
    public String helloWord() {
        return "Hello world!";
    }

}
