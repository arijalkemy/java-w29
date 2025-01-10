package org.example;

public class Prendas {

    private String marca;
    private String modelo;

    //constructor

    public Prendas() {
    }

    public Prendas(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    //getters y setters


    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    //to string

    @Override
    public String toString() {
        return "Prendas{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
