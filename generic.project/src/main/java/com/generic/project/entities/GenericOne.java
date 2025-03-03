package com.generic.project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Setter
@Getter
@Table(name = "sucursales")
public class GenericOne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String colonia;

    private int estado;

    @Column(name = "numero_domicilio")
    private int numero;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "sucursales_almacenes", joinColumns = @JoinColumn(name = "sucursales_id"),
            inverseJoinColumns = @JoinColumn(name = "almacenes_id"))
    @JsonIgnore
    private List<GenericTwo> genericTwo;

}
