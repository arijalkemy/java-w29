package org.meli.models;

import java.util.List;

public class Carrera {
    private Double distancia;
    private Double precioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

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


    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente, 1000.0, 4);
            vehiculos.add(auto);
        } else {
            System.out.println("No hay más cupo para vehículos en la carrera.");
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente, 300.0, 2);
            vehiculos.add(moto);
        } else {
            System.out.println("No hay más cupo para vehículos en la carrera.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (vehiculos.remove(vehiculo)) {
            System.out.println("El vehículo fue eliminado correctamente.");
        } else {
            System.out.println("El vehículo no se encontró en la carrera.");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        vehiculos.removeIf(v -> v.getPatente().equals(unaPatente));
        System.out.println("Se eliminó el vehículo con la patente: " + unaPatente);
    }

    public Vehiculo determinarGanador() {
        return vehiculos.stream()
                .max((v1, v2) -> Double.compare(
                        calcularValor(v1),
                        calcularValor(v2)
                ))
                .orElse(null);
    }

    private double calcularValor(Vehiculo v) {
        return v.getVelocidad() * 0.5 * v.getAceleracion() /
                (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100));
    }


    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPrecioEnDolares() {
        return precioEnDolares;
    }

    public void setPrecioEnDolares(Double precioEnDolares) {
        this.precioEnDolares = precioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }


    public Carrera(Double distancia, Double precioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.precioEnDolares = precioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }
}
