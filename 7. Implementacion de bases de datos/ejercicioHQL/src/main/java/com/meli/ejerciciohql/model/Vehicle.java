package com.meli.ejerciciohql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name="Vehicles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    private String patente;
    private String marca;
    private String modelo;
    @Column(name = "fabricacion_anio")
    private Integer fabricacionAnio;
    @Column(name = "cantidad_ruedas")
    private Integer cantidadRuedas;
    @OneToMany(mappedBy = "vehicle")
    private Set<Sinister> sinisters;

    public Vehicle(Integer fabricacionAnio, Integer cantidadRuedas, String marca, String modelo, String patente) {
        this.fabricacionAnio = fabricacionAnio;
        this.cantidadRuedas = cantidadRuedas;
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
    }
}
