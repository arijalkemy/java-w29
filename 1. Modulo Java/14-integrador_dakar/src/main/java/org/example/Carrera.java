package org.example;

import java.util.List;

public class Carrera {
    private Double distancia;
    private Double premioEnUSD;
    private String nombre;
    private Integer cantVehiculospermitidos;
    private List<Vehiculo> vehiculos;

    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public void socorrerAuto(String patente) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Autos && vehiculo.getPatente().equals(patente)) {
                socorristaAuto.socorrer(vehiculo);
                break;
            }
        }
    }

    public void socorrerMoto(String patente) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Moto && vehiculo.getPatente().equals(patente)) {
                socorristaMoto.socorrer(vehiculo);
                break;
            }
        }
    }

    //constructor

    public Carrera(Double distancia, Double premioEnUSD, String nombre, Integer cantVehiculospermitidos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnUSD = premioEnUSD;
        this.nombre = nombre;
        this.cantVehiculospermitidos = cantVehiculospermitidos;
        this.vehiculos = vehiculos;
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    //getters y setters

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPremioEnUSD() {
        return premioEnUSD;
    }

    public void setPremioEnUSD(Double premioEnUSD) {
        this.premioEnUSD = premioEnUSD;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantVehiculospermitidos() {
        return cantVehiculospermitidos;
    }

    public void setCantVehiculospermitidos(Integer cantVehiculospermitidos) {
        this.cantVehiculospermitidos = cantVehiculospermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    //Una carrera además tiene un conjunto de vehículos que participarán de la misma. Entonces, ahora la
    // carrera va a tener la responsabilidad de poder agregar a un vehículo, por lo que debemos definir los
    // siguientes métodos:
    //public void darDeAltaAuto(velocidad,aceleracion,AnguloDeGiro,patente);
    //public void darDeAltaMoto(velocidad,aceleracion,AnguloDeGiro,patente);
    //Ambos métodos agregan un vehículo siempre y cuando haya cupo.

    public void darDeAltaAuto(Integer velocidad, Double aceleracion,Double anguloDeGiro,String patente){
        if(vehiculos.size()<cantVehiculospermitidos){
            Autos auto= new Autos(velocidad,aceleracion,anguloDeGiro,patente);
            vehiculos.add(auto);
        }else {
            System.out.println("No se puede dar el vehiculo porque ya completamos la cantidad permitida de vehiculos.");

        }

    }

    public void darDeAltaMoto(Integer velocidad, Double aceleracion,Double anguloDeGiro,String patente){
        if(vehiculos.size()<cantVehiculospermitidos){
            Moto moto= new Moto(velocidad,aceleracion,anguloDeGiro,patente);
            vehiculos.add(moto);
        }else {
            System.out.println("No se puede dar el vehiculo porque ya completamos la cantidad permitida de vehiculos.");

        }

    }

    //También vamos a tener la posibilidad de eliminar a un vehículo mediante dos métodos:
    //public void eliminarVehiculo(vehículo);
    //public void eliminarVehiculoConPatente(String unaPatente);

    public void eliminarVehiculo(Vehiculo vehiculo){
        if(vehiculos.remove(vehiculo)){
            System.out.println("Vehiculo eliminado");
        }else {
            System.out.println("Vehiculo no existe");
        }
    }

    public void eliminarVehiculoPatente(String patente){
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
        System.out.println("Vehiculo con patente " +patente+ " eliminado");
    }

    //Queremos poder definir el ganador de una carrera:
    //El ganador será aquel que tenga el máximo valor determinado por la siguiente fórmula:
    //Velocidad * ½ Aceleracion / (AnguloDeGiro*(Peso-Cantidad de Ruedas * 100)

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
                (v.getAnguloGiro() * (v.getPeso() - v.getRuedas() * 100));
    }

}
