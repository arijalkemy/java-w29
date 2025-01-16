package model;

import java.util.*;

public class Carrera {

    private Double distancia;
    private Integer premioEnDolares;
    private String nombre;
    private Integer cantDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;

    SocorristaAuto socorristaAuto = new SocorristaAuto();
    SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Carrera(Double distancia, Integer premioEnDolares, String nombre, Integer cantDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantDeVehiculosPermitidos = cantDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente){
        if (vehiculos.size() < cantDeVehiculosPermitidos){
            vehiculos.add(new Auto(velocidad,aceleracion,anguloDeGiro,patente));
            System.out.println("El auto con patente: " + patente + " fue dado de alta.");
        }else{
            System.out.println("No se permiten mas vehiculos en esta carrera");
        }
    }

    public void darDeAltaMoto(Double velocidad,Double aceleracion,Double anguloDeGiro,String patente){

        if (vehiculos.size() < cantDeVehiculosPermitidos){
            vehiculos.add(new Moto(velocidad,aceleracion,anguloDeGiro,patente));
            System.out.println("La moto con patente: " + patente + " fue dado de alta.");
        }else{
            System.out.println("No se permiten mas vehiculos en esta carrera");
        }

    }

    public void eliminarVehiculo(Vehiculo vehiculo){

        if (vehiculos.contains(vehiculo)){
            vehiculos.remove(vehiculo);
            System.out.println("El vehiculo con patente " + vehiculo.getPatente() + " ah sido eliminado");
        }
        else{
            System.out.println("El vehiculo que quiere eliminar no existe en la carrera");
        }

    }

    public void eliminarVehiculoConPatente(String unaPatente){
        Vehiculo vehiculo = vehiculos.stream().filter(v -> v.getPatente().equals(unaPatente)).findAny().orElse(null);
        if (vehiculo != null){
            vehiculos.remove(vehiculo);
            System.out.println("El vehiculo con patente " + vehiculo.getPatente() + " ah sido eliminado");
        }
        else{
            System.out.println("El vehiculo que quiere eliminar no existe en la carrera");
        }

    };

    public Vehiculo vehiculoGanador(){
        return vehiculos.stream().max(Comparator.comparingDouble(Vehiculo::valorImportante)).get();
    }

    public void socorrerAuto(String patente){
        this.socorrerVehiculo(patente);
    };

    public void socorrerMoto(String patente){
        this.socorrerVehiculo(patente);
    };

    public void socorrerVehiculo(String patente){

        Optional<Vehiculo> vehiculo = vehiculos.stream().filter(v -> v.getPatente().equals(patente)).findAny();

        if(vehiculo.isPresent()){
            if(vehiculo.get() instanceof Auto){
                this.socorristaAuto.socorrer((Auto)vehiculo.get());
            }
            else{
                this.socorristaMoto.socorrer((Moto)vehiculo.get());
            }
        }
    }

}
