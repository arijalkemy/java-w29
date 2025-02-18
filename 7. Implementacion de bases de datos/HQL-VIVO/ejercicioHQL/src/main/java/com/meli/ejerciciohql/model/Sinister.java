package com.meli.ejerciciohql.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="Sinisters")
public class Sinister {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date fecha;
    private Double perdidaEconomica;
    @ManyToOne
    @JoinColumn(name = "Vehicle_id", nullable = false)
    private Vehicle vehicle;

    public Sinister(long id, Date fecha, Double perdidaEconomica, Vehicle vehicle) {
        this.id = id;
        this.fecha = fecha;
        this.perdidaEconomica = perdidaEconomica;
        this.vehicle = vehicle;
    }

    public Sinister(Date fecha, Double perdidaEconomica, Vehicle vehicle) {
        this.fecha = fecha;
        this.perdidaEconomica = perdidaEconomica;
        this.vehicle = vehicle;
    }

    public Sinister(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getPerdidaEconomica() {
        return perdidaEconomica;
    }

    public void setPerdidaEconomica(Double perdidaEconomica) {
        this.perdidaEconomica = perdidaEconomica;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Sinister{" +
                "id=" + id +
                ", fecha=" + fecha +
                ", perdidaEconomica=" + perdidaEconomica +
                ", vehicle=" + vehicle +
                '}';
    }
}
