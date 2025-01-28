package com.example;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        int reduccion = switch (diasPorCaducar) {
            case 1 -> 4;
            case 2 -> 3;
            case 3 -> 2;
            default -> 1;
        };

        return super.calcular(cantidadDeProductos) / reduccion;
    }

    @Override
    public String toString() {
        return super.toString() + " | Días por caducar: " + diasPorCaducar;
    }
}

