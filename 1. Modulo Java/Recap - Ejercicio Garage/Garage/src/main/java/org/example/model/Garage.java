package org.example.model;

import java.util.List;

public class Garage {

    private int id;
    private List<Vehicle> garage;

    public Garage(int id, List<Vehicle> garage) {
        this.id = id;
        this.garage = garage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehicle> getGarage() {
        return garage;
    }

    public void setGarage(List<Vehicle> garage) {
        this.garage = garage;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", garage=" + garage +
                '}';
    }
}
