package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<Vehiculo>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro,String patente){
        Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
        this.crearVehiculo(auto);
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro,String patente){
        Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
        this.crearVehiculo(moto);
    }
    private void crearVehiculo(Vehiculo vehiculo) {
        if(this.vehiculos.size() < this.cantidadDeVehiculosPermitidos){
            this.vehiculos.add(vehiculo);
        }
    }

    // 5.
    public void eliminarVehiculo(Vehiculo vehiculo){
        this.vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        Vehiculo v = buscarVehiculoPorPatente(patente);
        this.eliminarVehiculo(v);
    }

    private Vehiculo buscarVehiculoPorPatente(String patente) {
        return (Vehiculo) vehiculos.stream()
                .filter(ve -> ve.getPatente().equals(patente))
                .findFirst()
                .orElse(null);
    }

    // 6.
    public Vehiculo definirGanador(){
        return vehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::calcularValor))
                .orElseThrow(() -> new IllegalArgumentException("La lista de vehículos está vacía."));
    }

    // 7.
    public void socorrerAuto(String patente){
        Auto auto = (Auto) this.buscarVehiculoPorPatente(patente);
        if(auto != null) socorristaAuto.socorrer(auto);
    }
    public void socorrerMoto(String patente){
        Moto moto = (Moto) this.buscarVehiculoPorPatente(patente);
        if(moto != null) socorristaMoto.socorrer(moto);
    }

}
