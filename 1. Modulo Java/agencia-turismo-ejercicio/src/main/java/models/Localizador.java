package models;

import java.util.List;

public class Localizador {
    private String id;
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;

    public Localizador(String id, Cliente cliente, List<Reserva> reservas, double total) {
        this.id = id;
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "id='" + id + '\'' +
                ", cliente=" + cliente +
                ", reservas=" + reservas +
                ", total=" + total +
                '}';
    }
}
