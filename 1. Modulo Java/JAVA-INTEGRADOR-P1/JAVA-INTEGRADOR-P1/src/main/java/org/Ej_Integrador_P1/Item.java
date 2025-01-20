package org.Ej_Integrador_P1;

// Clase Item
class Item {
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

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "Código='" + codigo + '\'' +
                ", Nombre='" + nombre + '\'' +
                ", Cantidad=" + cantidad +
                ", Costo Unitario=" + costoUnitario +
                '}';
    }
}