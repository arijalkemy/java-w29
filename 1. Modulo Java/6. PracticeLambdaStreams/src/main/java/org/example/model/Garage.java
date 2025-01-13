package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Garage {
    /**
     * Attributes
     */
    private int id;
    private List<Vehicle> vehicleList = new ArrayList<>();

    /**
     * Costructor
     */
    public Garage(int id, List<Vehicle> vehicleList) {
        this.id = id;
        this.vehicleList = vehicleList;
    }

    /**
     * Getters and setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
