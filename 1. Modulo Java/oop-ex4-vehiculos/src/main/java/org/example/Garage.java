package org.example;

import java.util.List;

public class Garage {
    private String garageId;
    private List<Vehiculo> vehiculos;

    public Garage(String garageId, List<Vehiculo> vehiculos) {
        this.garageId = garageId;
        this.vehiculos = vehiculos;
    }

    public String getGarageId() {
        return garageId;
    }

    public void setGarageId(String garageId) {
        this.garageId = garageId;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
