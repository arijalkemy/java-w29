package org.example;

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

        if (estaInscripto(patente)) {
            System.out.println("El auto con patente " + patente + " ya está inscripto.");
        } else {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
            System.out.println("Auto inscripto " + patente);
        }

    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {

        if (!hayCupo()) {
            System.out.println("No hay cupo disponible.");
            return;
        }

        if (estaInscripto(patente)) {
            System.out.println("La moto con patente " + patente + " ya está inscripta.");
        } else {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
            System.out.println("Moto inscripto " + patente);
        }

    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        boolean vehiculoEliminado = vehiculos.remove(vehiculo);
        if(vehiculoEliminado) {
            System.out.println("Vehiculo " + vehiculo.getPatente() + " eliminado.");
        }else{
            System.out.println("Vehiculo " + vehiculo.getPatente() + " no eliminado.");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        boolean vehiculoEliminado = vehiculos.removeIf(v -> v.getPatente().equals(unaPatente));
        if(vehiculoEliminado) {
            System.out.println("Vehiculo " + unaPatente + " eliminado.");
        }else{
            System.out.println("Vehiculo " + unaPatente + " no eliminado.");
        }
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