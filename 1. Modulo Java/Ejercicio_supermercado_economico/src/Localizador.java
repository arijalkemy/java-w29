import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        return reservas.stream()
                .mapToDouble(Reserva::getTotal)
                .sum();
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

    private double aplicarDescuentos() {
        double descuento = 0;

        if (cliente.cantidadLocalizadores() >= 2) {
            descuento += total * 0.05;
        }

        if (reservas.size() == 4 &&
                reservas.stream().anyMatch(r -> r.getTipo().equals("hotel")) &&
                reservas.stream().anyMatch(r -> r.getTipo().equals("boleto")) &&
                reservas.stream().anyMatch(r -> r.getTipo().equals("comida")) &&
                reservas.stream().anyMatch(r -> r.getTipo().equals("transporte"))) {
            descuento += total * 0.10;
        }

        long conteoHotel = reservas.stream().filter(r -> r.getTipo().equals("hotel")).count();
        if (conteoHotel >= 2) {
            descuento += (reservas.stream()
                    .filter(r -> r.getTipo().equals("hotel"))
                    .mapToDouble(Reserva::getTotal).sum() * 0.05);
        }

        long conteoBoleto = reservas.stream().filter(r -> r.getTipo().equals("boleto")).count();
        if (conteoBoleto >= 2) {
            descuento += (reservas.stream()
                    .filter(r -> r.getTipo().equals("boleto"))
                    .mapToDouble(Reserva::getTotal).sum() * 0.05);
        }

        return total - descuento;
    }

    @Override
    public String toString() {
        return "Localizador para " + cliente.getNombre() + " " + cliente.getApellido() +
                " - Total original: " + total +
                ", Total después de descuentos: " + aplicarDescuentos();

    }
}