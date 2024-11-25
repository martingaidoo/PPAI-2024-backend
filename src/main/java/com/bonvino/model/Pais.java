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
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    
    @ToString.Exclude
    @OneToMany(targetEntity = Provincia.class, fetch = FetchType.LAZY, mappedBy = "pais")
    private List<Provincia> provincias;

    public String getNombre() {
        return this.nombre;
    }
}
