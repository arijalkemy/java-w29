package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Garage {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garage(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public <T extends Comparable<T>> List<Vehiculo> ordenarVehiculos(Function<Vehiculo, T> metodoGet) {
       return vehiculos.stream().sorted(Comparator.comparing(metodoGet)).toList();
    }

    public void mostrarVehiculos() {
        vehiculos.forEach(System.out::println);
        System.out.println();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

}
