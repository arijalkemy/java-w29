package com.integrador.dakar;

import java.util.Comparator;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premio;
    private String nombre;
    private Integer cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto = new SocorristaAuto();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        if(cantidadVehiculosPermitidos > vehiculos.size()){
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        if(cantidadVehiculosPermitidos > vehiculos.size()){
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        vehiculos = vehiculos.stream()
                .filter(vehiculo -> !vehiculo.getPatente().equals(patente)).toList();
    }

    public void obtenerGanador(){
        vehiculos.stream().max(Comparator.comparingDouble(Vehiculo::getPuntajeVelocidad))
                .ifPresent(System.out::println);
    }

    public void socorrerAuto(String patente){

        vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst()
                .ifPresent(vehiculo -> {
                    socorristaAuto.socorrer( (Auto) vehiculo);
                });
    }

    public void socorrerMoto(String patente){
        vehiculos.stream()
                .filter(vehiculo -> vehiculo.getPatente().equals(patente)).findFirst()
                .ifPresent(vehiculo -> {
                    socorristaMoto.socorrer( (Moto) vehiculo);
                });
    }

}
