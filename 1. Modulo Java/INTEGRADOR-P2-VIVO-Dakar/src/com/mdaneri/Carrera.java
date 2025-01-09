package com.mdaneri;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Carrera {

    private Integer distancia;
    private Integer premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Integer distancia, Integer premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;

        this.vehiculos = new ArrayList<>();
        socorristaAuto = new SocorristaAuto();
        socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Integer velocidad, Integer aceleracion, Double angulo, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos)
            vehiculos.add(new Auto(velocidad, aceleracion, angulo, patente));
    }

    public void darDeAltaMoto(Integer velocidad, Integer aceleracion, Double angulo, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos)
            vehiculos.add(new Moto(velocidad, aceleracion, angulo, patente));
    }

    public void eliminarVehiculo(Vehiculo v) {
        vehiculos.remove(v);
    }

    public void eliminarVehiculoConPatente(String patente) {
        Optional<Vehiculo> optionalVehiculo = vehiculos.stream().filter(v -> patente.equals(v.getPatente())).findFirst();
        optionalVehiculo.ifPresent(vehiculo -> vehiculos.remove(vehiculo));
    }

    public Vehiculo ganador() {
        return vehiculos
                .stream()
                .max((v1, v2) -> Double.compare(score(v1), score(v2))).orElse(null);
    }

    public void socorrerAuto(String patente) {
        Optional<Vehiculo> optionalVehiculo = vehiculos.stream().filter(v -> patente.equals(v.getPatente())).findFirst();
        optionalVehiculo.ifPresent(v -> socorristaAuto.socorrer((Auto) v));
    }

    public void socorrerMoto(String patente) {
        Optional<Vehiculo> optionalVehiculo = vehiculos.stream().filter(v -> patente.equals(v.getPatente())).findFirst();
        optionalVehiculo.ifPresent(v -> socorristaMoto.socorrer((Moto) v));
    }

    private double score(Vehiculo v) {
        return v.getVelocidad() * (Math.sqrt(v.getAceleracion()) / (v.getAngulo() * (v.getPeso() - v.getRuedas()) * 100));
    }

}
