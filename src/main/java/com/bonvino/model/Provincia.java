package com.bonvino.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import jakarta.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Provincia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToOne(targetEntity = Pais.class)
    private Pais pais;

    @ToString.Exclude
    @OneToMany(targetEntity = RegionVitivinicola.class, fetch = FetchType.LAZY, mappedBy = "provincia")
    private List<RegionVitivinicola> regionesVitivinicolas;

    public String getNombre() {
        return this.nombre;
    }

    public String obtenerPais() {
        return this.pais.getNombre();
    }
}
