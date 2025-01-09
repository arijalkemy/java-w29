package org.bootcamp;

public class Prenda {
    private String marca;
    private String modelo;

    @Override
    public String toString() {
        return "Prenda{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
}
