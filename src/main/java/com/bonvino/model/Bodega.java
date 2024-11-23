package com.bonvino.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
/**
 * @description Clase que representa una bodega de vinos
 * @table bodega Tabla en base de datos que almacena las bodegas
 * @id Clave primaria autogenerada
 * @nombre Nombre de la bodega
 * @descripcion Descripción de la bodega
 * @historia Historia de la bodega
 * @periodoActualizacion Período de actualización de los vinos de la bodega
 * @coordenadasUbicacion Coordenadas de la ubicación de la bodega
 * @regionVitivinicola Región vitivinícola a la que pertenece la bodega
 */
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
