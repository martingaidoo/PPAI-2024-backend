package com.bonvino.service.strategyGenerarRankingVino;

import com.bonvino.model.Vino;

public interface IEstrategia {

    public Vino[] buscarVinosConReseñasPorTipoYEnFecha(String fecha);

    public float[] calcularCalificacionesPromedio(String fecha);
}