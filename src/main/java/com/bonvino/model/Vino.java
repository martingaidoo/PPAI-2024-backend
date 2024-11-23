package com.bonvino.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date añada;
    private String nombre;
    private String calificacionGeneral;
    private float precioARS;

    @OneToMany(targetEntity = Varietal.class)
    private Varietal[] varietal = new Varietal[0];
    @OneToMany(targetEntity = Resena.class)
    private Resena[] resena = new Resena[0];
    @ManyToOne(targetEntity = Bodega.class)
    private Bodega bodega;


    public Boolean tieneResenaEnFecha(Date fechaInicio, Date fechaFin) {
        for (Resena resena_i : resena) { // esta variable reseña no tiene sentido, seguramente este vacia, debe buscar todas las reseñas del vino
            if (resena_i.estaEnPeriodo(fechaInicio, fechaFin)) {
                if(resena_i.sosDeSommelier()){
                    return true;
                }
            }
        }
        return false;
    }

    public float calcularRanking(Date fechaInicio, Date fechaFin) {
        float puntaje = 0;
        int contadorSommelier = 0;
        for (Resena resena_i : resena) {
            if (resena_i.estaEnPeriodo(fechaInicio, fechaFin) && resena_i.sosDeSommelier()) {
                puntaje += resena_i.getPuntaje();
                contadorSommelier++;
            }
        }
        return contadorSommelier > 0 ? puntaje / contadorSommelier : 0;
    }

    public String obtenerBodega() {
        return this.bodega.getNombre();
    }

    public String[] obtenerVarietal() {
        // method implementation
        return new String[0];
    }

    public float getPrecioARS() {
        return precioARS;
    }

    public void setPrecioARS(float precioARS) {
        this.precioARS = precioARS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalificacionGeneral() {
        return calificacionGeneral;
    }

    public void setCalificacionGeneral(String calificacionGeneral) {
        this.calificacionGeneral = calificacionGeneral;
    }

}
