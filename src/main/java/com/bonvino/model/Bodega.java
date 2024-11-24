package com.bonvino.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;

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

    public String getNombre() {
        return this.nombre;
    }

    public List<String> obtenerUbicacion() {
        List<String> datosUbicacion = new ArrayList<String>();
        datosUbicacion.add(regionVitivinicola.getNombre());
        datosUbicacion.addAll(regionVitivinicola.obtenerProvincia());
        return datosUbicacion;
    }
}
