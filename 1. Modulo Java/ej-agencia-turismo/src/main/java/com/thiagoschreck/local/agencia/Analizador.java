package com.thiagoschreck.local.agencia;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class Analizador {

    public static void imprimirDatos() {
        System.out.printf("Cantidad de localizadores vendidos: %s%n", getCantidadDeLocalizadoresVendidos());
        System.out.printf("Cantidad total de reservas: %s%n", getCantidadDeReservas());
        System.out.printf("Diccionario de todas las reservas: %s%n", getReservasPorTipo());
        System.out.printf("Total de ventas: $%s%n", getTotalDeVentas());
        System.out.printf("Promedio de todas las ventas: $%s%n", getPromedioDeVentas());
    }

    private static int getCantidadDeLocalizadoresVendidos() {
        return LocalizadorRepository.getLocalizadores().size();
    }

    private static List<Reserva> getTodasLasReservas() {
        return LocalizadorRepository.getLocalizadores().stream()
                .map(Localizador::getReservas)
                .flatMap(Collection::stream)
                .toList();
    }

    private static int getCantidadDeReservas() {
        return getTodasLasReservas().size();
    }

    private static Map<Reserva.Tipo, List<Reserva>> getReservasPorTipo() {
        Map<Reserva.Tipo, List<Reserva>> reservasClasificadas = new HashMap<>();
        getTodasLasReservas()
                .forEach(reserva -> reservasClasificadas.put(
                        reserva.tipo(),
                        Stream.concat(
                                Optional.ofNullable(reservasClasificadas.get(reserva.tipo()))
                                        .orElse(Collections.emptyList())
                                        .stream(),
                                Stream.of(reserva)
                        ).toList())
                );
        return reservasClasificadas;
    }

    private static double getTotalDeVentas() {
        return getTodasLasReservas().stream()
                .map(Reserva::valor)
                .reduce(Double::sum)
                .orElse(0.0);
    }

    private static double getPromedioDeVentas() {
        List<Reserva> reservas = getTodasLasReservas();
        if (reservas.isEmpty()) {
            return 0;
        }
        return getTotalDeVentas() / reservas.size();
    }
}
