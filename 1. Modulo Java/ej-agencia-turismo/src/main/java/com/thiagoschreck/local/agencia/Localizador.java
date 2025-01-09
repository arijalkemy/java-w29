package com.thiagoschreck.local.agencia;

import java.util.List;

public class Localizador {
    private final List<Reserva> reservas;
    private final Cliente cliente;

    public Localizador(List<Reserva> reservas, Cliente cliente) {
        this.reservas = reservas;
        this.cliente = cliente;

        LocalizadorRepository.addLocalizador(this);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    private double getTotalConDescuento() {
        return getTotal() - getDescuento();
    }

    private double getDescuento() {
        return (double) getPorcentajeDescuento() / 100 * getTotal();
    }

    private double getTotal() {
        return reservas.stream()
                .map(Reserva::valor)
                .reduce(0.0, Double::sum);
    }

    private int getPorcentajeDescuento() {
        int descuento = 0;

        List<Localizador> localizadoresPrevios = LocalizadorRepository.getLocalizadoresByCliente(cliente);
        if (localizadoresPrevios.size() >= 2) {
            descuento += 5;
        }

        List<Reserva.Tipo> tipos = reservas.stream().map(Reserva::tipo).toList();
        final List<Reserva.Tipo> tiposDescuento10 = List.of(Reserva.Tipo.HOTEL, Reserva.Tipo.COMIDA, Reserva.Tipo.BOLETO, Reserva.Tipo.TRANSPORTE);
        if (tipos.containsAll(tiposDescuento10)) {
            descuento += 10;
        }

        final List<Reserva.Tipo> tiposHotelDescuento5 = List.of(Reserva.Tipo.HOTEL, Reserva.Tipo.HOTEL);
        final List<Reserva.Tipo> tiposBoletoDescuento5 = List.of(Reserva.Tipo.BOLETO, Reserva.Tipo.BOLETO);
        if (tipos.containsAll(tiposHotelDescuento5) || tipos.containsAll(tiposBoletoDescuento5)) {
            descuento += 5;
        }

        return descuento;
    }

    @Override
    public String toString() {
        return String.format("""
                Cliente: %s
                Reservas:
                ---------
                %s
                ---------
                Descuento: $%s (%s%%)
                Total: $%s
                Total con descuento: $%s
                """,
                cliente,
                reservas.stream().map(reserva -> String.format("* %s%n", reserva)).reduce("", String::concat),
                getDescuento(),
                getPorcentajeDescuento(),
                getTotal(),
                getTotalConDescuento()
        );
    }
}