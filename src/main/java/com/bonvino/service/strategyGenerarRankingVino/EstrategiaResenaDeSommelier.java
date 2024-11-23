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

    
    private final RepositoryVino repositoryVino;

    // Inyección del repositorio por constructor
    public EstrategiaResenaDeSommelier(RepositoryVino repositoryVino) {
        this.repositoryVino = repositoryVino;
    }


    @Override
    public Vino[] buscarVinosConReseñasPorTipoYEnFecha(Date fechaInicio, Date fechaFin) {
        // Lista temporal para almacenar los vinos con reseñas
        List<Vino> vinosConResena = new ArrayList<>();

        // Obtener todos los vinos del repositorio
        List<Vino> vinos = repositoryVino.findAll();

        // Iterar sobre la lista de vinos
        for (Vino vino : vinos) {
            // Verificar si el vino tiene reseñas en el rango de fechas
            if (vino.tieneResenaEnFecha(fechaInicio, fechaFin)) {
                vinosConResena.add(vino);
            }
        }

        // Convertir la lista a un array y retornarla
        return vinosConResena.toArray(new Vino[0]);
    }

    public void tomarFormaVisualizacionReporte() {
        // Método vacío
    }

    public void tomarConfirmacionReporte() {
        // Método vacío
    }

    public Object[] calcularCalificacionesPromedio(Date fechaInicio, Date fechaFin, Vino[] vinosFiltradosPorResena) {
        // Utilizar una lista para agregar dinámicamente los resultados
        List<Object[]> calificacionesPromedioVino = new ArrayList<>();

        for (Vino vino : vinosFiltradosPorResena) {
            // Crear un array para representar el vino y su calificación promedio
            Object[] vinoConCalificacionPromedio = new Object[2];
            vinoConCalificacionPromedio[0] = vino; // Asignar el objeto Vino
            vinoConCalificacionPromedio[1] = vino.calcularRanking(fechaInicio, fechaFin); // Asignar la calificación promedio

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
