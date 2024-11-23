package com.bonvino.service.strategyGenerarRankingVino;

import com.bonvino.model.Vino;
import java.util.Date;


public interface IEstrategia {

    public Vino[] buscarVinosConReseñasPorTipoYEnFecha(Date fechaInicio, Date fechaFin);

    public Object[] calcularCalificacionesPromedio(Date fechaInicio, Date fechaFin, Vino[] vinosFiltradosPorResena);
}