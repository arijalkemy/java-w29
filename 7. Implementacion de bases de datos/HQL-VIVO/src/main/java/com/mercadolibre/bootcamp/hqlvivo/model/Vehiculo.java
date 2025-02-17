package com.mercadolibre.bootcamp.hqlvivo.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String patente;
    private String marca;
    private String modelo;
    private LocalDate fechaFabricacion;
    private Integer ruedas;

    @OneToMany(mappedBy = "vehiculoDenunciado")
    private List<Siniestro> siniestros;

    public Vehiculo() {}

    public Long getId() {
        return id;
    }

    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public Integer getRuedas() {
        return ruedas;
    }

    public List<Siniestro> getSiniestros() {
        return siniestros;
    }
}
