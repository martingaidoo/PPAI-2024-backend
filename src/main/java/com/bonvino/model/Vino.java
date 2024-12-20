package com.bonvino.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    private float calificacionGeneral;
    private float precioARS;
    
    
    @ToString.Exclude
    @OneToMany(targetEntity = Resena.class, fetch = FetchType.LAZY, mappedBy = "vino")
    private List<Resena> resenas;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "vino_varietal", joinColumns = @JoinColumn(name = "vino_id"), inverseJoinColumns = @JoinColumn(name = "varietal_id"))
    private List<Varietal> varietal;

    @ManyToOne(targetEntity = Bodega.class, fetch = FetchType.LAZY)
    private Bodega bodega;

    public Boolean tieneResenaEnFecha(Date fechaInicio, Date fechaFin) {
        for (Resena resena_i : resenas) { // esta variable reseña no tiene sentido, seguramente este vacia, debe buscar
                                      // todas las reseñas del vino
            if (resena_i.estaEnPeriodo(fechaInicio, fechaFin)) {
                if (resena_i.sosDeSommelier()) {
                    return true;
                }
            }
        }
        return false;
    }

    public float calcularRanking(Date fechaInicio, Date fechaFin) {
        float puntaje = 0;
        int contadorSommelier = 0;
        for (Resena resena_i : resenas) {
            if (resena_i.estaEnPeriodo(fechaInicio, fechaFin) && resena_i.sosDeSommelier()) {
                puntaje += resena_i.getPuntaje();
                contadorSommelier++;
            }
        }
        return contadorSommelier > 0 ? puntaje / contadorSommelier : 0;
    }

    public String[] obtenerBodega() {
        List<String> datosBodega = new ArrayList<>();
        datosBodega.add(bodega.getNombre());
        datosBodega.addAll(bodega.obtenerUbicacion());
        return datosBodega.toArray(new String[0]);
    }

    public String[] obtenerVarietal() {
        String[] descripciones = new String[varietal.size()];
        int i = 0;
        for (Varietal varietal_i : varietal) {
            descripciones[i] = varietal_i.getDescripcion();
            i++;
        }
        return descripciones;
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

    public float getCalificacionGeneral() {
        return calificacionGeneral;
    }

    public void setCalificacionGeneral(float calificacionGeneral) {
        this.calificacionGeneral = calificacionGeneral;
    }

    public void setVarietal(List<Varietal> varital) {
        this.varietal = varital;
    }

    public void setResenas(List<Resena> resenas) {
        this.resenas = resenas;
    }
}
