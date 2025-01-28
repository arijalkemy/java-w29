package org.example;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private String id;
    private List<Vehiculo> vehiculos;

    public Garaje(String id) {
    this.id = id;
    this.vehiculos = new ArrayList<>();
}

    public void agregarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }


    public String getId() {
        return id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}