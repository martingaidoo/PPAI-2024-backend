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
public class RegionVitivinicola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    @ManyToOne(targetEntity = Provincia.class, fetch = FetchType.LAZY)
    private Provincia provincia;

    public String getNombre() {
        return this.nombre;
    }

    public List<String> obtenerProvincia() {
        List<String> datosProvincia = new ArrayList<String>();
        datosProvincia.add(provincia.getNombre());
        datosProvincia.add(provincia.obtenerPais());
        return datosProvincia;
    }
}
