package com.bootcamp.showroom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ventas")
@Getter
@Setter
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;
    private LocalDate fecha;
    private Double total;
    private String medioPago;
    @ManyToMany
    @JoinTable(
            name = "venta_prenda",
            joinColumns = @JoinColumn(name = "venta_numero"),
            inverseJoinColumns = @JoinColumn(name = "prenda_codigo")
    )
    private Set<Prenda> prendas = new HashSet<>();
}
