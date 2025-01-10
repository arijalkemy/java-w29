package model;

import lombok.Data;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Data
@ToString
public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private Double total = 0.0;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        this.total = this.reservas.stream().mapToDouble(Reserva::getValor).sum();
        double descuento = 0;

        if (cliente.getLocalizadores().size() >= 2) {
            descuento += total * 0.05;
        }

        if (esPaqueteCompleto(reservas)) {
            descuento += total * 0.10;
        }

        descuento += getDescuentoByTipo(TipoReserva.HOTEL);
        descuento += getDescuentoByTipo(TipoReserva.BOLETOS);

        return descuento == 0 ? total : total - descuento;
    }

    private double getDescuentoByTipo(TipoReserva tipo) {
        double descuento = 0;
        long conteoBoleto = reservas.stream().filter(r -> r.getTipo().equals(tipo)).count();
        if (conteoBoleto >= 2) {
            descuento += (reservas.stream()
                    .filter(r -> r.getTipo().equals(tipo))
                    .mapToDouble(Reserva::getValor).sum() * 0.05);
        }
        return descuento;
    }

    private boolean esPaqueteCompleto(List<Reserva> reservas) {
        List<TipoReserva> tipos = reservas.stream().map(Reserva::getTipo).toList();
        final List<TipoReserva> tiposDescuento10 = Arrays.asList(TipoReserva.values());
        return tipos.containsAll(tiposDescuento10);
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "reservas=" + reservas +
                ", total=" + total +
                '}';
    }
}
