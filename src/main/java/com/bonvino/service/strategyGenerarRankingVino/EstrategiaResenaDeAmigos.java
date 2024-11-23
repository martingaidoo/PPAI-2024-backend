package com.bonvino.service.strategyGenerarRankingVino;

import org.springframework.stereotype.Service;
import com.bonvino.model.Vino;

import java.util.Date;

@Service
public class EstrategiaResenaDeAmigos implements IEstrategia {

    // Esta sintaxis es solo para los metodos 
    // que no se implementaron para esta entrega

    @Override
    public Object[] calcularCalificacionesPromedio(Date fechaInicio, Date fechaFin, Vino[] vinosFiltradosPorResena) {
        return new Object[0];
    }

    @Override
    public Vino[] buscarVinosConReseñasPorTipoYEnFecha(Date fechaInicio, Date fechaFin) {
        throw new UnsupportedOperationException("Método no implementado");
    }
}