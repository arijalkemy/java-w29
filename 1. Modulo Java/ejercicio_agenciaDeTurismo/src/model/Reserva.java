package model;

public class Reserva {

    private String nombre;
    private Double precio;

    public String getNombre() {
        return nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public Reserva(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;

    }

}
