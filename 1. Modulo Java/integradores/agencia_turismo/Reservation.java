package com.example.demo.integradores.agencia_turismo;

class Reservation {
    private String type;
    private double cost;

    public Reservation(String type, double cost) {
        this.type = type;
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public double getCost() {
        return cost;
    }
}
