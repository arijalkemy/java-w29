package com.meli.ejerciciohql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name="Vehicles")
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

    public Vehicle(long id, String patente, String marca, String modelo, Integer fabricacionAnio, Integer cantidadRuedas, Set<Sinister> sinisters) {
        this.id = id;
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.fabricacionAnio = fabricacionAnio;
        this.cantidadRuedas = cantidadRuedas;
        this.sinisters = sinisters;
    }

    public Vehicle(Integer fabricacionAnio, Integer cantidadRuedas, String marca, String modelo, String patente) {
        this.fabricacionAnio = fabricacionAnio;
        this.cantidadRuedas = cantidadRuedas;
        this.marca = marca;
        this.modelo = modelo;
        this.patente = patente;
    }
    public Vehicle(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getFabricacionAnio() {
        return fabricacionAnio;
    }

    public void setFabricacionAnio(Integer fabricacionAnio) {
        this.fabricacionAnio = fabricacionAnio;
    }

    public Integer getCantidadRuedas() {
        return cantidadRuedas;
    }

    public void setCantidadRuedas(Integer cantidadRuedas) {
        this.cantidadRuedas = cantidadRuedas;
    }

    public Set<Sinister> getSinisters() {
        return sinisters;
    }

    public void setSinisters(Set<Sinister> sinisters) {
        this.sinisters = sinisters;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", patente='" + patente + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", fabricacionAnio=" + fabricacionAnio +
                ", cantidadRuedas=" + cantidadRuedas +
                ", sinisters=" + sinisters +
                '}';
    }
}
