package org.example.model;

import java.util.Comparator;
import java.util.List;

public class Carrera {
    private final double distancia;
    private final double premioEnDolares;
    private final String nombre;
    private final int cantidadVehiculosPermitidos;
    private final List<Vehiculo> listaDeVehiculos;
    private final Socorrista socorristaAuto;
    private final Socorrista socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadVehiculosPermitidos, List<Vehiculo> listaDeVehiculos, SocorristaAuto socorristaAuto, SocorristaMoto socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.listaDeVehiculos = listaDeVehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (sePuedeAgregarVehiculo()){
            listaDeVehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (sePuedeAgregarVehiculo()) {
            listaDeVehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void eliminarVehiculo(String patente) {
        listaDeVehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        eliminarVehiculo(vehiculo.getPatente());
    }

    public Vehiculo definirGanador() {
        return listaDeVehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::getPuntajeVelocidad))
                .orElse(null);
    }

    private boolean sePuedeAgregarVehiculo() {
        if (listaDeVehiculos.size() >= cantidadVehiculosPermitidos) {
            System.out.println("Se ha alcanzado el límite de vehículos permitidos. No se ha registrado el vehículo.");
            return false;
        }
        return true;
    }
}
