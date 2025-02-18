package com.meli.ejerciciohql.model.DTO;

import com.meli.ejerciciohql.model.Vehicle;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

public class SinisterDto {
    private Date fecha;
    private Double perdidaEconomica;
    private Vehicle vehicle;

    public SinisterDto(Date fecha, Double perdidaEconomica, Vehicle vehicle) {
        this.fecha = fecha;
        this.perdidaEconomica = perdidaEconomica;
        this.vehicle = vehicle;
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
        return "SinisterDto{" +
                "fecha=" + fecha +
                ", perdidaEconomica=" + perdidaEconomica +
                ", vehicle=" + vehicle +
                '}';
    }
}
