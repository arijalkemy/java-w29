package com.mercadolibre.bootcamp.hqlvivo.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate fechaSiniestro;
    private Double perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculoDenunciado;

    public Siniestro() {}




}
