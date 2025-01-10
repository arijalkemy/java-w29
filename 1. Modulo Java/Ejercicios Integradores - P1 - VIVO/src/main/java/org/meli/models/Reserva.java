package org.meli.models;

public class Reserva {
    private String tipo;
    private double total;

    public Reserva(String tipo, double total) {
        this.tipo = tipo;
        this.total = total;
    }

    public String getTipo() {
        return tipo;
    }

    public double getTotal() {
        return total;
    }
}
