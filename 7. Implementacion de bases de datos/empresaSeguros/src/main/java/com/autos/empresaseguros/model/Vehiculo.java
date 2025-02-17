package com.autos.empresaseguros.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
@Table(name = "vehiculo")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    @Column(name = "anio_fabricacion")
    private int anioFabricacion;
    @Column(name = "cantidad_ruedas")
    private int cantidadRuedas;
}
