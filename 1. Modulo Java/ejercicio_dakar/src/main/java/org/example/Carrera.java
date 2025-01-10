package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Carrera {
    private float distancia;
    private float premioEnDolares;
    private String nombre;
    private int cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    private Socorrista<Auto> socorristaAuto;
    private Socorrista<Moto> socorristaMoto;

    public Carrera(float distancia, float premioEnDolares, String nombre, int cantidadVehiculosPermitidos, List<Vehiculo> vehiculos, Socorrista<Auto> socorristaAuto, Socorrista<Moto> socorristaMoto) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.socorristaAuto = socorristaAuto;
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaAuto(float velocidad, float aceleracion, float anguloDeGiro, String patente) {
        if (verificarCapacidad()) return;
        vehiculos.add(
                new Auto(velocidad, aceleracion, anguloDeGiro, patente)
        );
    }

    public void darDeAltaMoto(float velocidad, float aceleracion, float anguloDeGiro, String patente) {
        if (verificarCapacidad()) return;
        vehiculos.add(
                new Moto(velocidad, aceleracion, anguloDeGiro, patente)
        );
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        vehiculos = vehiculos
                .stream()
                .filter(v -> !mismaPatente(patente, v))
                .collect(Collectors.toList());
    }

    public Vehiculo ganador() {
        return vehiculos
                .stream()
                .sorted((v1, v2) -> factorDeVictoria(v1).compareTo(factorDeVictoria(v2)))
                .toList()
                .getFirst();
    }

    public void socorrerAuto(String patente) {
        socorristaAuto.socorrer((Auto) vehiculos
                .stream()
                .filter(v -> mismaPatente(patente, v))
                .toList()
                .getFirst());
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    private static boolean mismaPatente(String patente, Vehiculo v) {
        return v.getPatente().equals(patente);
    }

    public void socorrerMoto(String patente) {
        socorristaMoto.socorrer((Moto) vehiculos
                .stream()
                .filter(v -> mismaPatente(patente, v))
                .toList()
                .getFirst()
        );
    }

    private Double factorDeVictoria(Vehiculo v) {
        return  v.getVelocidad() * v.getAceleracion() * 0.5 / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100));
    }

    private boolean verificarCapacidad() {
        if (vehiculos.size() + 1 > cantidadVehiculosPermitidos) {
            System.out.println("No se puede dar de alta: Limite de vehiculos alcanzado");
            return true;
        }
        return false;
    }


}




