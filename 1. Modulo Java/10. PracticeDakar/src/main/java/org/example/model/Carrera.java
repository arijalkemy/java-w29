package org.example.model;

import java.util.Comparator;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioDolares;
    private String nombre;
    private int cantVehiculos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioDolares, String nombre, int cantVehiculos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioDolares = premioDolares;
        this.nombre = nombre;
        this.cantVehiculos = cantVehiculos;
        this.vehiculos = vehiculos;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioDolares() {
        return premioDolares;
    }

    public void setPremioDolares(double premioDolares) {
        this.premioDolares = premioDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantVehiculos() {
        return cantVehiculos;
    }

    public void setCantVehiculos(int cantVehiculos) {
        this.cantVehiculos = cantVehiculos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        if (cantVehiculos <= vehiculos.size()) {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            throw new IllegalArgumentException("No hay cupo de vehiculos");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, int anguloDeGiro, String patente) {
        if (cantVehiculos <= vehiculos.size()) {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        } else {
            throw new IllegalArgumentException("No hay cupo de vehiculos");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    private double obtenerDatoFormula(Vehiculo vehiculo) {
        return (vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2)) / (vehiculo.getAnguloGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
    }

    public Vehiculo obtenerGanador() {
        return vehiculos.stream().max(Comparator.comparing(this::obtenerDatoFormula)).orElse(null);
    }

    public void socorrerAuto(String patente) {
        socorristaAuto.socorrer((Auto) vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst().orElseThrow());
    }

    public void socorrerMoto(String patente) {
        socorristaAuto.socorrer((Moto) vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst().orElseThrow());
    }
}
