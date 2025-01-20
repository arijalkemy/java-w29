package org;

import java.util.List;

// Clase Localizador
class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        calcularTotal();
    }

    private void calcularTotal() {
        total = reservas.stream().mapToDouble(Reserva::getCosto).sum();

        // Verificar descuentos por tipo de paquete
        long totalReservasHotel = reservas.stream().filter(r -> r.getTipo().equals("hotel")).count();
        long totalBoletos = reservas.stream().filter(r -> r.getTipo().equals("boleto")).count();
        boolean paqueteCompleto = reservas.stream().map(Reserva::getTipo).distinct().count() == 4;

        if (paqueteCompleto) {
            total *= 0.9; // 10% descuento por paquete completo
        }

        if (totalReservasHotel >= 2 || totalBoletos >= 2) {
            total *= 0.95; // 5% descuento por múltiples reservas del mismo tipo
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    @Override
    public String toString() {
        return "Localizador{" + "cliente=" + cliente + ", reservas=" + reservas + ", total=" + total + '}';
    }
}
