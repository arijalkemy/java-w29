package com.example.demo.integradores.dakar;

import com.example.demo.integradores.dakar.socorristas.SocorristaAuto;
import com.example.demo.integradores.dakar.socorristas.SocorristaMoto;

import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
        //  Set
    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    /* 4
    Una carrera además tiene un conjunto de vehículos que participarán de la misma. Entonces, ahora la carrera va a tener la responsabilidad de poder agregar a un vehículo, por lo que debemos definir los siguientes métodos:
    public void darDeAltaAuto(velocidad,aceleracion,AnguloDeGiro,patente);
    public void darDeAltaMoto(velocidad,aceleracion,AnguloDeGiro,patente);
    Ambos métodos agregan un vehículo siempre y cuando haya cupo.
     */

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }


    /* 5
    También vamos a tener la posibilidad de eliminar a un vehículo mediante dos métodos:

     */
    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public boolean eliminarVehiculoConPatente(String unaPatente) {
        return vehiculos.removeIf(v -> v.getPatente().equals(unaPatente));
    }
    /* 6
    Definir ganador
     */

    /*

     */
    public Vehiculo definirGanador() {
        return vehiculos.stream()
                .max((v1, v2) -> Double.compare(v1.getPerformance(), v2.getPerformance()))
                .orElse(null);
    }
    /* 8
     Métodos para socorrer vehículos en Carrera
     */
    private SocorristaAuto socorristaAuto = new SocorristaAuto();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();

    public void socorrerAuto(String patente) {
        vehiculos.stream()
                .filter(v -> v instanceof Auto && v.getPatente().equals(patente))
                .findFirst()
                .ifPresent(v -> socorristaAuto.socorrer((Auto) v));
    }

    public void socorrerMoto(String patente) {
        vehiculos.stream()
                .filter(v -> v instanceof Moto && v.getPatente().equals(patente))
                .findFirst()
                .ifPresent(v -> socorristaMoto.socorrer((Moto) v));
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        return "Carrera{" +
                "distancia=" + distancia +
                ", premioEnDolares=" + premioEnDolares +
                ", nombre='" + nombre + '\'' +
                ", cantidadDeVehiculosPermitidos=" + cantidadDeVehiculosPermitidos +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
