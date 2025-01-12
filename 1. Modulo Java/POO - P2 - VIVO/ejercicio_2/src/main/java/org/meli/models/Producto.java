package org.meli.models;

public class Producto {
        private String nombre;
    private Double precio;

    public Double getPrecio() {
        return precio;
    }

    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    public Double calcular(Integer cantidadDeProductos) {
        return precio * cantidadDeProductos;
    }
}

