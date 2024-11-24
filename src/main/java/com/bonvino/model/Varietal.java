package com.bonvino.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Varietal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private float porcentajeComposicion;

    @ManyToOne(targetEntity = Vino.class, fetch = FetchType.LAZY)
    private Vino vino;

    public String getDescripcion() {
        return this.descripcion;
    }
}