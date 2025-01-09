package com.example.model;

import lombok.Data;

import java.util.List;

@Data
public class Localizador {

    private Cliente cliente;

    private List<Reserva> reservas;

    private double total;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        calcularTotal();
    }

    public void aplicarDescuento(double porcentaje) {
        this.total *= (1 - porcentaje);
    }

    private void calcularTotal() {
        this.total = reservas.stream().mapToDouble(Reserva::getPrecio).sum();
    }

}
