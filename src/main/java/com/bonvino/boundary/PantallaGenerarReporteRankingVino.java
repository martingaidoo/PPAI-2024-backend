package com.bonvino.boundary;

import com.bonvino.controller.GestorGenerarReporteRankingVino;
import com.bonvino.dto.GenerarReporteRankingVinoRequest;

import java.net.http.HttpHeaders;

import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
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
    public ResponseEntity<byte[]> opcionGenerarRankingDeVinos(@RequestBody GenerarReporteRankingVinoRequest request) {
        try {
            // Llamar al gestor para obtener el archivo Excel en formato byte[]
            byte[] archivoExcel = gestor.opcionGenerarRankingVino(request);

            return ResponseEntity.ok()
                    .contentType(org.springframework.http.MediaType.APPLICATION_OCTET_STREAM)
                    .body(archivoExcel);

        } catch (Exception e) {
            e.printStackTrace();
            // En caso de error, devolver un código HTTP 500
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/hello")
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello, World!");
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
