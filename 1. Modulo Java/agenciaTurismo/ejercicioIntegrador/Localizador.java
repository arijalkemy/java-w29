package ejercicioIntegrador;

import ejercicioIntegrador.Reserva;

import java.util.List;
import java.util.UUID;

class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;
    private String id;

    public Localizador(Cliente cliente, List<Reserva> reservas, double total) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = total;
        this.id = UUID.randomUUID().toString();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "id='" + id + '\'' +
                ", cliente=" + cliente +
                ", reservas=" + reservas.size() +
                ", total=" + total +
                '}';
    }
}