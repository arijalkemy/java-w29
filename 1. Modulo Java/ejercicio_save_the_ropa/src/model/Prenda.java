package model;

public class Prenda {
    private String marca;
    private String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return String.format("\t - Marca: %-15s | Modelo: %-15s", marca, modelo);
    }
}
