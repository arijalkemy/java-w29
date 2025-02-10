package com.example.empresa.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "vehiculos")
@Data
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String marca;

    private String modelo;

    private String patente;

    private Integer anio;

    @Column(name = "cantidad_ruedas")
    private Integer cantidadRuedas;

    @OneToMany(mappedBy = "vehiculo")
    private List<Siniestro> siniestros;
}
