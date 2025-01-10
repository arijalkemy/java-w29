package org.example.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private final Integer cantidadDeVehiculosPermitidos;
    List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<Vehiculo>();
        socorristaAuto = new SocorristaAuto();
        socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (vehiculos.size() >= cantidadDeVehiculosPermitidos) {
            System.out.println("El auto no puede ser incscripto ya que están todos los cupos ocupados");
        } else vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (vehiculos.size() >= cantidadDeVehiculosPermitidos) {
            System.out.println("La moto no puede ser incscripto ya que están todos los cupos ocupados");
        } else vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculo(String patente) {
        vehiculos.stream().filter(v -> patente.equals(v.getPatente())).findFirst().ifPresentOrElse(
                (v) -> vehiculos.remove(v),
                () -> System.out.println("No se encontró registrado un vehiculo con la patente: " + patente)
        );
    }

    public void obtenerGanador() {
        vehiculos
                .stream()
                .max(Comparator.comparingDouble(v -> (v.getVelocidad()*(v.getAceleracion()/2/(v.getAnguloDeGiro()*(v.getPeso()-v.getRuedas()*100))))))
                .ifPresentOrElse((v) -> System.out.println("El ganador es: " + v),
                        () -> System.out.println("No hay un ganador"));
    }

    public void socorrerAuto(String patente) {
        Optional<Vehiculo> vehiculoOptional = getVehiculo(patente);
        if (vehiculoOptional.isPresent()) {
            Vehiculo vehiculo = vehiculoOptional.get();
            if (vehiculo instanceof Auto) {
                socorristaAuto.socorrer((Auto) vehiculo);
            } else {
                System.out.printf("El vehiculo con patente %s no es un auto por lo que no se lo puede socorrer con el socorrista de autos\n", vehiculo.getPatente());
            }
        } else {
            System.out.printf("No se encontró el auto con la patente: %s por lo que no se lo puede socorrer\n", patente);
        }
    }

    public void socorrerMoto(String patente) {
        Optional<Vehiculo> vehiculoOptional = getVehiculo(patente);
        if (vehiculoOptional.isPresent()) {
            Vehiculo vehiculo = vehiculoOptional.get();
            if (vehiculo instanceof Moto) {
                socorristaMoto.socorrer((Moto) vehiculo);
            } else {
                System.out.printf("El vehiculo con patente %s no es una moto por lo que no se lo puede socorrer con el socorrista de motos\n", vehiculo.getPatente());
            }
        } else {
            System.out.printf("No se encontró la moto con la patente: %s por lo que no se lo puede socorrer\n", patente);
        }
    }

    private Optional<Vehiculo> getVehiculo(String patente) {
        return vehiculos.stream().filter(v -> patente.equals(v.getPatente())).findFirst();
    }
}
