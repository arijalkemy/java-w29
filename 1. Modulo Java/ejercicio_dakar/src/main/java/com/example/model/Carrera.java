package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
public class Carrera {

    private Double distancia;

    private Double premioEnDolares;

    private String nombre;

    private Integer cantidadDeVehiculosPermitidos;

    private final List<Vehiculo> vehiculos = new ArrayList<>();

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

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){

        if (!hayCupo()) {
            System.out.println("No hay cupo disponible.");
            return;
        }

        if (!estaInscripto(patente)) {
            System.out.println("Esta moto ya está inscripta.");
        }

        vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public boolean eliminarVehiculo(Vehiculo vehiculo) {
        return vehiculos.remove(vehiculo);
    }

    public boolean eliminarVehiculoConPatente(String unaPatente) {
        return vehiculos.removeIf(v -> v.getPatente().equals(unaPatente));
    }

    public Vehiculo definirGanador() {
        return vehiculos.stream()
                .max(Comparator.comparingDouble(v ->
                        v.getVelocidad() * 0.5 * v.getAceleracion() / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100))
                )).orElse(null);
    }

    private boolean hayCupo() {
        return vehiculos.size() < cantidadDeVehiculosPermitidos;
    }

    private boolean estaInscripto(String patente) {
        return vehiculos.stream().anyMatch(v -> v.getPatente().equals(patente));
    }

}
