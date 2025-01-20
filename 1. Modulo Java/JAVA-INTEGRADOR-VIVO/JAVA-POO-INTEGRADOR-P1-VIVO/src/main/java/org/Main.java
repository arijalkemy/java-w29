package org;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear repositorio de clientes
        RepositorioCliente repositorio = new RepositorioCliente();

        // Crear cliente
        Cliente cliente = new Cliente("001", "Juan Pérez");

        // Crear localizador con un paquete completo
        List<Reserva> paqueteCompleto = Arrays.asList(
                new Reserva("hotel", 500),
                new Reserva("comida", 100),
                new Reserva("boleto", 300),
                new Reserva("transporte", 200)
        );
        Localizador localizador1 = new Localizador(cliente, paqueteCompleto);
        repositorio.agregarLocalizador(localizador1);
        System.out.println("Localizador 1 creado: " + localizador1);

        // Crear localizador con 2 reservas de hotel y 2 boletos
        List<Reserva> multipleReservas = Arrays.asList(
                new Reserva("hotel", 500),
                new Reserva("hotel", 500),
                new Reserva("boleto", 300),
                new Reserva("boleto", 300)
        );
        Localizador localizador2 = new Localizador(cliente, multipleReservas);
        repositorio.agregarLocalizador(localizador2);
        System.out.println("Localizador 2 creado: " + localizador2);

        // Crear localizador con una sola reserva
        List<Reserva> reservaUnica = List.of(new Reserva("comida", 100));
        Localizador localizador3 = new Localizador(cliente, reservaUnica);
        repositorio.agregarLocalizador(localizador3);
        System.out.println("Localizador 3 creado: " + localizador3);

        // Mostrar todos los localizadores del cliente
        System.out.println("\nLocalizadores del cliente:");
        repositorio.obtenerLocalizadores(cliente.getId()).forEach(System.out::println);
    }
}