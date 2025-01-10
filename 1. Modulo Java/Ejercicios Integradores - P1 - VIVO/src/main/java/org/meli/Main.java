package org.meli;

import org.meli.models.Cliente;
import org.meli.models.Localizador;
import org.meli.models.Reserva;
import org.meli.repositories.RepositorioCliente;

import java.util.Arrays;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        RepositorioCliente repositorio = new RepositorioCliente();

        Cliente cliente1 = new Cliente("Juan", "Pérez");
        Cliente cliente2 = new Cliente("Holmes", "Ramirez");

        repositorio.agregarCliente(cliente1);
        repositorio.agregarCliente(cliente2);

        Localizador localizador1 = new Localizador(cliente1, Arrays.asList(
                new Reserva("hotel", 1000),
                new Reserva("comida", 200),
                new Reserva("boleto", 500),
                new Reserva("transporte", 300)
        ));
        cliente1.agregarLocalizador(localizador1);
        System.out.println(localizador1);

        Localizador localizador2 = new Localizador(cliente1, Arrays.asList(
                new Reserva("hotel", 1200),
                new Reserva("hotel", 1100),
                new Reserva("boleto", 600),
                new Reserva("boleto", 550)
        ));
        cliente1.agregarLocalizador(localizador2);
        System.out.println(localizador2);

        Localizador localizador3 = new Localizador(cliente1, Arrays.asList(
                new Reserva("comida", 150)
        ));
        cliente1.agregarLocalizador(localizador3);
        System.out.println(localizador3);

        Localizador localizador4 = new Localizador(cliente2, Arrays.asList(
                new Reserva("hotel", 1200),
                new Reserva("hotel", 1100)
        ));
        cliente2.agregarLocalizador(localizador4);
        System.out.println(localizador4);

        System.out.println("\nCantidad de localizadores vendidos: " + repositorio.cantidadTotalLocalizadores());
        System.out.println("Cantidad total de reservas: " + repositorio.cantidadTotalReservas());

        Map<String, Long> reservasClasificadas = repositorio.obtenerReservasClasificadas();
        System.out.println("Reservas clasificadas por tipo: " + reservasClasificadas);

        double totalVentas = repositorio.totalVentas();
        System.out.println("Total de ventas: " + totalVentas);

        double promedioVentas = repositorio.promedioVentas();
        System.out.println("Promedio de ventas: " + promedioVentas);

    }
}