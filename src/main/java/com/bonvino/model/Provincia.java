package com.bonvino.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @OneToMany(targetEntity = RegionVitivinicola.class, fetch = FetchType.LAZY, mappedBy = "provincia") // Espera
                                                                                                        // solicitud
                                                                                                        // para traer
    // las regiones
    private List<RegionVitivinicola> regionesVitivinicolas;
}
