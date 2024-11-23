package com.bonvino.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bodega {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Clave primaria autogenerada
    private Long id;

    private String nombre;
    private String descripcion;
    private String historia;
    private String periodoActualizacion;
    private String coordenadasUbicacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_vitivinicola_id", nullable = false) // Clave foránea
    private RegionVitivinicola regionVitivinicola;
}
