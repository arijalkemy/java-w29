package com.bootcamp;

import java.util.List;

public class Garaje {

    private int id;
    private List<Vehiculo> vehiculos;

    public Garaje(int id, List<Vehiculo> listaVehiculos) {
        this.id = id;
        this.vehiculos = listaVehiculos;
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

    @Override
    public String toString() {
        return "Garaje{" +
                "id=" + id +
                ", listaVehiculos=" + vehiculos +
                '}';
    }
}
