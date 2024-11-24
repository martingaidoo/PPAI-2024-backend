package com.bonvino.service.strategyGenerarRankingVino;

import org.springframework.stereotype.Service;
import com.bonvino.model.Vino;
import java.util.List;
import java.util.Date;

@Service
public class EstrategiaResenaDeAmigos implements IEstrategia {

    // Esta sintaxis es solo para los metodos
    // que no se implementaron para esta entrega

    @Override
    public Object[] calcularCalificacionesPromedio(Date fechaInicio, Date fechaFin,
            List<Vino> vinosFiltradosPorResena) {
        return new Object[0];
    }

    @Override
    public List<Vino> buscarvinosFiltradosPorResenasPorTipoYEnFecha(Date fechaInicio, Date fechaFin, List<Vino> vinos) {
        throw new UnsupportedOperationException("Método no implementado");
    }
}
