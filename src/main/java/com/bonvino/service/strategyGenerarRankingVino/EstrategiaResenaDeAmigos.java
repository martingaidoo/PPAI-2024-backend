package com.bonvino.service.strategyGenerarRankingVino;

import java.util.List;
import org.springframework.stereotype.Service;
import com.bonvino.service.strategyGenerarRankingVino.IEstrategia;
import com.bonvino.model.Vino;

@Service
public class EstrategiaResenaDeAmigos implements IEstrategia {

    // Esta sintaxis es solo para los metodos 
    // que no se implementaron para esta entrega

    @Override
    public float[] calcularCalificacionesPromedio(String tipo) {
        return new float[0];
    }

    @Override
    public Vino[] buscarVinosConReseñasPorTipoYEnFecha(String fecha) {
        throw new UnsupportedOperationException("Método no implementado");
    }
}
