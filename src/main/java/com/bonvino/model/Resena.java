package com.bonvino.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Resena {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comentario;
    private Date fechaResena;
    private float puntaje;
    private boolean esDeSommelier;

    @OneToOne
    @JoinColumn(name = "vino_id")
    private Vino vino;

    public boolean estaEnPeriodo(Date fechaInicio, Date fechaFin) {
        return fechaResena.after(fechaInicio) && fechaResena.before(fechaFin);
    }

    public boolean sosDeSommelier() {
        return esDeSommelier;
    }

    public float getPuntaje() {
        return puntaje;
    }
}
