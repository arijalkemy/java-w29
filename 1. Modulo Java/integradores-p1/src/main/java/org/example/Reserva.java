package org.example;

public class Reserva {

    private Double precio;
    private Cliente cliente;

    public Reserva(Double precio, Cliente cantidad) {
        this.precio = precio;
        this.cliente = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "\n" + this.getClass().getSimpleName() + " {" +
                "precio=" + precio +
                ", cliente=" + cliente +
                '}';
    }
}
