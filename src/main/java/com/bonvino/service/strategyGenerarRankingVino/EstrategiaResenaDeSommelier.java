package com.bonvino.service.strategyGenerarRankingVino;

import java.util.List;
import org.springframework.stereotype.Service;

import com.bonvino.service.strategyGenerarRankingVino.IEstrategia;
import com.bonvino.model.Vino;
import com.bonvino.repository.RepositoryVino;
import java.util.Date;
import java.util.ArrayList;

@Service
public class EstrategiaResenaDeSommelier implements IEstrategia {

    // Inyección del repositorio por constructor

    @Override
    public List<Vino> buscarvinosFiltradosPorResenasPorTipoYEnFecha(Date fechaInicio, Date fechaFin, List<Vino> vinos) {
        // Lista temporal para almacenar los vinos con reseñas
        
        if (vinos == null || vinos.isEmpty()) {
            throw new IllegalStateException("No entran vinos  ");
        
        }
        
        List<Vino> vinosConResena = new ArrayList<>();

        // Obtener todos los vinos del repositorio

        // Iterar sobre la lista de vinos
        for (Vino vino : vinos) {
            // Verificar si el vino tiene reseñas en el rango de fechas
            if (vino.tieneResenaEnFecha(fechaInicio, fechaFin)) {
                vinosConResena.add(vino);
            }
        }

        // Convertir la lista a un array y retornarla
        if (vinosConResena == null || vinosConResena.isEmpty()) {
            System.out.println(vinosConResena);
            throw new IllegalStateException("No entran vinos  ");
                  
        }
        
        return vinosConResena;
    }

    public void tomarFormaVisualizacionReporte() {
        // Método vacío
    }

    public void tomarConfirmacionReporte() {
        // Método vacío
    }

    public Object[] calcularCalificacionesPromedio(Date fechaInicio, Date fechaFin,
            List<Vino> vinosFiltradosPorResena) {
        // Utilizar una lista para agregar dinámicamente los resultados
        List<Object[]> calificacionesPromedioVino = new ArrayList<>();

        for (Vino vino : vinosFiltradosPorResena) {
            // Crear un array para representar el vino y su calificación promedio
            Object[] vinoConCalificacionPromedio = new Object[2];
            vinoConCalificacionPromedio[0] = vino; // Asignar el objeto Vino
            vinoConCalificacionPromedio[1] = vino.calcularRanking(fechaInicio, fechaFin); // Asignar la calificación
                                                                                          // promedio

            // Agregar el resultado a la lista
            calificacionesPromedioVino.add(vinoConCalificacionPromedio);
        }

        // Convertir la lista a un arreglo y retornarlo
        return calificacionesPromedioVino.toArray(new Object[0][]);
    }

    public void getTipoReporteSeleccionado() {
        // Método vacío
    }

    public String tomarSeleccionTipoReporte(String fechaInicio, String fechaFin, String tipoReporteSeleccionado) {
        return "Reporte generado";
    }

}
