package com.bootcamp.siniestros.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anio;
    @Column(name = "cantidad_ruedas")
    private Integer cantidadRuedas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vehiculo")
    private Set<Siniestro> siniestros;
}
