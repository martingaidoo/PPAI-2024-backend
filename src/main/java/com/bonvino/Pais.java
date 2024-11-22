package com.bonvino;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    @OneToMany(targetEntity = Provincia.class, fetch = FetchType.LAZY, mappedBy = "pais") // pasa como foranea para no// crear una tabla intermedia
    private List<Provincia> provincias;

}
