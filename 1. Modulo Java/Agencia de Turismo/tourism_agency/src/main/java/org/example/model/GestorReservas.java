package org.example.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GestorReservas {

    private List<Cliente> repositorioCliente;

    public GestorReservas(List<Cliente> repo) {
        this.repositorioCliente = repo;
    }

    public void generarLocalizador(Cliente cliente, List<Reserva> reservas) {

        repositorioCliente.add(cliente);
        Localizador localizador = new Localizador(cliente, reservas);

        // Aplicar descuentos
        new DescuentoPorLocalizadores().aplicar(localizador);
        new DescuentoPaqueteCompleto().aplicar(localizador);
        new DescuentoPorReservasRepetidas().aplicar(localizador);

        // Almacenar el localizador
        cliente.addLocalizador(localizador);
        System.out.println(localizador);
    }

    public static long cantidadLocalizadores(List<Localizador> localizadores) {
        return localizadores.size();
    }

    public static long cantidadTotalReservas(List<Localizador> localizadores) {
        return localizadores.stream().mapToLong(l -> l.getReservas().size()).sum();
    }

    public static Map<String, Long> reservasPorTipo(List<Localizador> localizadores) {
        return localizadores.stream()
                .flatMap(l -> l.getReservas().stream())
                .collect(Collectors.groupingBy(Reserva::getType, Collectors.counting()));
    }

    public static double totalVentas(List<Localizador> localizadores) {
        return localizadores.stream().mapToDouble(Localizador::getTotal).sum();
    }

    public static double promedioVentas(List<Localizador> localizadores) {
        return totalVentas(localizadores) / cantidadLocalizadores(localizadores);
    }

}
