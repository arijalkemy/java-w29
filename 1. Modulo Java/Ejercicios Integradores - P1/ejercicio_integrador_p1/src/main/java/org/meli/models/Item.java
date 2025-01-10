package org.meli.models;

public class Item {
    private String codigo;
    private String nombre;
    private int cantidad;
    private double costoUnitario;

    public Item(String codigo, String nombre, int cantidad, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    public double calcularCostoTotal() {
        return cantidad * costoUnitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", costoUnitario=" + costoUnitario +
                ", costoTotal=" + calcularCostoTotal() +
                '}';
    }
}
