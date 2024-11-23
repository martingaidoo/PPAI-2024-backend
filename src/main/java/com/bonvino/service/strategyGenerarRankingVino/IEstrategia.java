package com.bonvino.service.strategyGenerarRankingVino;

import com.bonvino.model.Vino;
import java.util.Date;
import java.util.List;
import com.bonvino.repository.RepositoryVino;

public interface IEstrategia {

    public List<Vino> buscarVinosConReseñasPorTipoYEnFecha(Date fechaInicio, Date fechaFin, List<Vino> vinos);

    public Object[] calcularCalificacionesPromedio(Date fechaInicio, Date fechaFin, List<Vino> vinosFiltradosPorResena);
}