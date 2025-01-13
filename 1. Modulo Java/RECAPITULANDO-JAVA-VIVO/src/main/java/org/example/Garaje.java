package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Garaje {

    private int id;
    private List<Vehiculo> listaVehiculos;

    public Garaje(int id, List<Vehiculo> listaVehiculos) {
        this.id = id;
        this.listaVehiculos = listaVehiculos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }


    public List<Vehiculo> getVehiculosbyprecio() {
        return listaVehiculos.stream()
                .sorted(Comparator.comparingInt(Vehiculo::getPrecio))
                .collect(Collectors.toList());
    }

    public List<Vehiculo> getVehiculosbyMarcaYPrecio() {
        return listaVehiculos.stream()
                .sorted(Comparator
                        .comparing(Vehiculo::getMarca)
                        .thenComparingInt(Vehiculo::getPrecio))
                .collect(Collectors.toList());
    }

    public List<Vehiculo> getVehiculosMenorCostoMaximo() {
        return listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPrecio() < 1000)
                .collect(Collectors.toList());

    }
    public List<Vehiculo> getVehiculosMayorQue() {
        return listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getPrecio() >= 1000)
                .collect(Collectors.toList());

    }

    public Double getPromedioVehiculos() {
        return listaVehiculos.stream()
                .mapToInt(Vehiculo::getPrecio)
                .average().orElse(0);
    }


    @Override
    public String toString() {
        return "Garaje{" +
                "id=" + id +
                ", listaVehiculos=" + listaVehiculos +
                '}';
    }
}
