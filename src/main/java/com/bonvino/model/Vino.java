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
    private Varietal[] varietal;
    @OneToMany(targetEntity = Resena.class)
    private Resena[] resena;
    @ManyToOne(targetEntity = Bodega.class)
    private Bodega bodega;

    public Resena[] tieneResenaEnFecha(Date fechaInicio, Date fechaFin) {
        List<Resena> resenasFiltradas = new ArrayList<>();
        for (Resena resena_i : resena) {
            if (resena_i.estaEnPeriodo(fechaInicio, fechaFin)) {
                resenasFiltradas.add(resena_i);
            }
        }
        return resenasFiltradas.toArray(new Resena[0]);
    }

    public float calcularRanking(Date fechaInicio, Date fechaFin) {
        Resena[] resenasFiltradas = tieneResenaEnFecha(fechaInicio, fechaFin);
        float sumaPuntajes = 0;
        int contadorSommelier = 0;
        for (Resena resena : resenasFiltradas) {
            if (resena.sosDeSommelier() && resena.estaEnPeriodo(fechaInicio, fechaFin)) {
                sumaPuntajes += resena.getPuntaje();
                contadorSommelier++;
            }
        }
        if (contadorSommelier == 0) {
            return 0;
        }
        return sumaPuntajes / contadorSommelier;
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
