package com.example.demo.integradores.agencia_turismo;

import java.util.List;

class Locator {
    private Client client;
    private List<Reservation> reservations; // string y double
    private double total;
    private final int LIMIT;

    public Locator(Client client, List<Reservation> reservations) {
        this.client = client;
        this.reservations = reservations;
        this.total = calculateTotal();
        this.LIMIT = 2;
    }

    private double calculateTotal() {
                                                            // (x) cost <-
        double subtotal = reservations.stream().mapToDouble(Reservation::getCost).sum(); // acumulo gasto en reservas
        boolean hasHotel = reservations.stream().anyMatch(r -> r.getType().equals("Hotel"));
        boolean hasFood = reservations.stream().anyMatch(r -> r.getType().equals("Comida"));
        boolean hasTickets = reservations.stream().anyMatch(r -> r.getType().equals("Boletos"));
        boolean hasTransport = reservations.stream().anyMatch(r -> r.getType().equals("Transporte"));

        if (client.hasDiscount()) { // Apagador
            subtotal *= 0.95; // Ahora
            // client.resetDiscount();
        }

        if (hasHotel && hasFood && hasTickets && hasTransport) subtotal *= 0.90; // Paquete completo 10% Off


        long hotelCount = reservations.stream().filter(r -> r.getType().equals("Hotel")).count();
        long ticketsCount = reservations.stream().filter(r -> r.getType().equals("Boletos")).count();

        /*
        Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje,
        se aplicará un descuento de 5% en esas reservas.
         */


        // Sólo a la 1 y 2 hacemos descuento! ! !
        //  [1, 2, 3, 4, 5]
        if (hotelCount >= LIMIT) { // al menos 2 de alguna 5% Off
            subtotal -= reservations.stream() // descuento específico de ésta reserva
                    .filter(r -> r.getType().equals("Hotel"))
                    .limit(LIMIT)
                    .mapToDouble(r -> r.getCost() * 0.05).sum();
        }
        if (ticketsCount >= LIMIT) { // al menos 2 de alguna 5% Off
            subtotal -= reservations.stream() // descuento específico de ésta reserva
                    .filter(r -> r.getType().equals("Boletos"))
                    .limit(LIMIT)
                    .mapToDouble(r -> r.getCost() * 0.05).sum();
        }

        return subtotal;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void printDetails() {
        System.out.println("Cliente: " + client.getName());
        System.out.println("Reservas:");
        reservations.forEach(r -> System.out.println("- " + r.getType() + ": $" + r.getCost()));
        System.out.println("Total: $" + total);
    }
}
