package org.example;

import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private int id;
    private List<Vehiculo> garaje;

    public void agregarVehiculoGaraje(Vehiculo garaje) {
        this.garaje.add(garaje);
    }
    public Garaje(int id) {
        this.id = id;
        this.garaje = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getGaraje() {
        return garaje;
    }

    public void setGaraje(List<Vehiculo> garaje) {
        this.garaje = garaje;
    }
}
