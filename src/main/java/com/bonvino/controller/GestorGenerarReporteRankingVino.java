package com.bonvino.controller;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Service;

import com.bonvino.boundary.PantallaGenerarReporteRankingVino;
import com.bonvino.dto.GenerarReporteRankingVinoRequest;
import com.bonvino.service.strategyGenerarRankingVino.EstrategiaResenaDeAmigos;
import com.bonvino.service.strategyGenerarRankingVino.EstrategiaResenaDeSommelier;
import com.bonvino.service.strategyGenerarRankingVino.EstrategiaResenaNormal;
import com.bonvino.service.strategyGenerarRankingVino.IEstrategia;
import com.bonvino.model.Vino;

@Service
public class GestorGenerarReporteRankingVino {
    
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
    private Vino[] vinosRankeados;
    private Vino[] vinosRanking10;
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

    public void opcionGenerarRankingVino(GenerarReporteRankingVinoRequest request) {
        this.pantalla.solicitarSeleccionFechasInicioFin(request);
        this.pantalla.mostrarYSolicitarTipoReporte(request);
        this.pantalla.solicitarConfirmacionReporte(request);
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
            this.calcularCalificacionesPromedio();
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
        this.vinosConReseña = this.estrategiaElegida.buscarVinosConReseñasPorTipoYEnFecha(this.fechaInicio, this.fechaFin);
    }

    public void calcularCalificacionesPromedio() {
        this.estrategiaElegida.calcularCalificacionesPromedio( this.fechaInicio,this.fechaFin, this.vinosFiltradosPorReseña);
    }

    public void setEstrategiaElegida(IEstrategia estrategiaElegida) {
        this.estrategiaElegida = estrategiaElegida;
    }   

}
