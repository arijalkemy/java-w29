package org.example;

public class Main {
    public static void main(String[] args) {
        RepositorioCliente repositorioCliente = new RepositorioCliente();
        Cliente clienteAndres = new Cliente("Andres", "1", "3123123");
        Cliente clienteJose = new Cliente("Jose", "2", "4123123");

        System.out.println("\nParte 1.1");
        Localizador localizador = new Localizador(clienteAndres);
        localizador.agregarReserva(new ReservaHotel(500000.0, clienteAndres));
        localizador.agregarReserva(new ReservaComida(300000.0, clienteAndres));
        localizador.agregarReserva(new ReservaBoleto(200000.0, clienteAndres));
        localizador.agregarReserva(new ReservaTransporte(50000.0, clienteAndres));

        repositorioCliente.agregarLocalizador(clienteAndres, localizador);

        System.out.println("\nParte 1.2");
        Localizador localizador2 = new Localizador(clienteAndres);

        localizador2.agregarReserva(new ReservaHotel(500000.0, clienteAndres));
        localizador2.agregarReserva(new ReservaHotel(500000.0, clienteJose));
        localizador2.agregarReserva(new ReservaBoleto(200000.0, clienteAndres));
        localizador2.agregarReserva(new ReservaBoleto(200000.0, clienteJose));
        localizador2.agregarReserva(new ReservaTransporte(50000.0, clienteAndres));

        repositorioCliente.agregarLocalizador(clienteAndres, localizador2);

        System.out.println("\nParte 1.3");
        Localizador localizador3 = new Localizador(clienteAndres);

        localizador3.agregarReserva(new ReservaHotel(500000.0, clienteAndres));

        repositorioCliente.agregarLocalizador(clienteAndres, localizador3);
    }
}