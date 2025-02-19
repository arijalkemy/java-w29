package com.bootcamp.showroom.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "prendas")
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;
    private String tipo;
    private String talla;
    private String color;
    private String marca;
    private Integer cantidad;
    private Double precioVenta;
    @ManyToMany(mappedBy = "prendas")
    @JsonIgnore
    private Set<Venta> ventas = new HashSet<>();
}
