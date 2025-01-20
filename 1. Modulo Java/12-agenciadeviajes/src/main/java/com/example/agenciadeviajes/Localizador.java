package com.example.agenciadeviajes;

import java.util.List;

public class Localizador {
    private Viajero viajero;
    private List<Reserva> reservas;
    private Double total;
    private final Integer LIMIT;

    public Localizador(Viajero viajero, List<Reserva> reservas) {
        this.LIMIT = 2;
        this.viajero = viajero;
        this.reservas = reservas;
        this.total = this.calcularTotal();
    }

    private double calcularTotal() {
        // (x) cost <-
        double subtotal = reservas.stream().mapToDouble(Reserva::getCosto).sum(); // acumulo gasto en reservas
        boolean incluyeHotel = reservas.stream().anyMatch(r -> r.getTipo().equals("Hotel"));
        boolean incluyeComida = reservas.stream().anyMatch(r -> r.getTipo().equals("Comida"));
        boolean incluyeBoletos = reservas.stream().anyMatch(r -> r.getTipo().equals("Boletos"));
        boolean incluyeTransporte = reservas.stream().anyMatch(r -> r.getTipo().equals("Transporte"));

        if (viajero.getTieneDescuento()) {
            subtotal *= 0.95;
        }

        if (incluyeHotel && incluyeComida && incluyeBoletos && incluyeTransporte) subtotal *= 0.90;


        long hotelContador = reservas.stream().filter(r -> r.getTipo().equals("Hotel")).count();
        long boletoContador = reservas.stream().filter(r -> r.getTipo().equals("Boletos")).count();

        /*
        Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje,
        se aplicará un descuento de 5% en esas reservas.
         */


        // Sólo a la 1 y 2 hacemos descuento! ! !
        //  [1, 2, 3, 4, 5]
        if (hotelContador >= LIMIT) { // al menos 2 de alguna 5% Off
            subtotal -= reservas.stream() // descuento específico de ésta reserva
                    .filter(r -> r.getTipo().equals("Hotel"))
                    .limit(LIMIT)
                    .mapToDouble(r -> r.getCosto() * 0.05).sum();
        }
        if (boletoContador >= LIMIT) {
            subtotal -= reservas.stream()
                    .filter(r -> r.getTipo().equals("Boletos"))
                    .limit(LIMIT)
                    .mapToDouble(r -> r.getCosto() * 0.05).sum();
        }

        return subtotal;
    }

    public List<Reserva> getReservations() {
        return this.reservas;
    }

    public void printDetalle() {
        System.out.println("Viajero: " + viajero.getNombre());
        System.out.println("Reservas:");
        reservas.forEach(r -> System.out.println("- " + r.getTipo() + ": $" + r.getCosto()));
        System.out.println("Total: $" + total);
    }
}
