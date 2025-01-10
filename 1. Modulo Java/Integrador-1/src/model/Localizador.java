package model;

import java.util.List;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double totalDescuento;
    private double totalFinal;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;

        // Calcular total antes de descuentos
        double total = reservas.stream().mapToDouble(Reserva::getTotal).sum();
        this.totalFinal = aplicarDescuentos(cliente, total);
    }

    private double aplicarDescuentos(Cliente cliente, double total) {
        double descuento = 0;

        // Descuento por paquetes completos
        boolean paqueteCompleto = reservas.stream().map(Reserva::getTipo).distinct().count() == 4;
        if (paqueteCompleto) {
            descuento += 0.10; // 10% de descuento
        }

        // Descuento por cantidad de localizadores
        if (cliente.cantidadReservas() >= 2) {
            descuento += 0.05; // 5% de descuento
        }

        // Descuentos por cantidad de reservas
        long cantidadHoteles = reservas.stream().filter(r -> r.getTipo().equals("hotel")).count();
        long cantidadBoletos = reservas.stream().filter(r -> r.getTipo().equals("boleto")).count();
        if (cantidadHoteles >= 2 || cantidadBoletos >= 2) {
            descuento += 0.05; // 5% de descuento
        }

        // Aplicar descuentos
        totalDescuento = total * descuento;
        return total - totalDescuento;
    }

    public void imprimir() {
        System.out.println("Localizador para el cliente: " + cliente.getNombre());
        System.out.println("Reservas: " + reservas);
        System.out.println("Total sin descuento: " + reservas.stream().mapToDouble(Reserva::getTotal).sum());
        System.out.println("Descuento aplicado: " + totalDescuento);
        System.out.println("Total final: " + totalFinal);
    }


}