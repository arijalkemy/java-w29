import java.util.List;

public class Localizador {
    private final Cliente cliente;
    private final List<Reserva> reservas;
    private double total;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
    }

    private double calculaTotal() {
        return reservas.stream().mapToDouble(Reserva::getPrecio).sum();
    }

    public double getTotal() {
        return total;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "cliente=" + cliente.getNombre() +
                ", reservas=" + reservas +
                ", total=" + total +
                '}';
    }
}
