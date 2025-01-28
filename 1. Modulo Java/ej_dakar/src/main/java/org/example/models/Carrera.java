package org.example.models;


import lombok.Builder;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Builder
public class Carrera {

    private Double distancia;

    private Double precioEnDolares;

    private String nombre;

    private Integer cantidadDeVehiculosPermitidos;

    @Builder.Default
    private List<Vehiculo> vehiculos = new ArrayList<>();

    @Builder.Default
    private SocorristaAuto socorristaAuto = new SocorristaAuto();

    @Builder.Default
    private SocorristaMoto socorristaMoto = new SocorristaMoto();

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (!hayCupo()) {
            System.out.println("No hay cupo disponible.");
            return;
        }

        if (!estaInscripto(patente)) {
            System.out.println("Este auto ya está inscripto.");
        }

        vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (!hayCupo()) {
            System.out.println("No hay cupo disponible.");
            return;
        }

        if (!estaInscripto(patente)) {
            System.out.println("Esta moto ya está inscripta.");
        }

        vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        boolean eliminado = vehiculos.remove(vehiculo);

        if (eliminado) {
            System.out.println("Vehiculo eliminado.");
        } else {
            System.out.println("El vehículo no se encuentra inscripto.");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        boolean eliminado = vehiculos.removeIf(v -> v.getPatente().equals(unaPatente));

        if (eliminado) {
            System.out.println("Vehiculo eliminado.");
        } else {
            System.out.println("El vehículo no se encuentra inscripto.");
        }
    }

    public Optional<Vehiculo> determinarGanador() {
        return vehiculos.stream().max(Comparator.comparingDouble(Vehiculo::calcularPuntaje));
    }

    public void socorrer(Vehiculo vehiculo) {
        if (vehiculo instanceof Auto) {
            socorristaAuto.socorrer((Auto) vehiculo);
        } else if (vehiculo instanceof Moto) {
            socorristaMoto.socorrer((Moto) vehiculo);
        }
    }

    private boolean hayCupo() {
        return vehiculos.size() < cantidadDeVehiculosPermitidos;
    }

    private boolean estaInscripto(String patente) {
        return vehiculos.stream().anyMatch(v -> v.getPatente().equals(patente));
    }
}
