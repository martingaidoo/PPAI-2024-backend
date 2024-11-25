package com.bonvino.boundary;

import com.bonvino.controller.GestorGenerarReporteRankingVino;
import com.bonvino.dto.GenerarReporteRankingVinoRequest;
import com.bonvino.model.Vino;
import java.util.List;
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
    }


}
