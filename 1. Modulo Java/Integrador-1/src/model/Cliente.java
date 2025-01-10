package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<Reserva> reservas;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public int cantidadReservas() {
        return reservas.size();
    }

    public double totalReservas() {
        return reservas.stream().mapToDouble(Reserva::getTotal).sum();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", reservas=" + reservas +
                '}';
    }
}