package com.example.agenciadeviajes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ViajeroRepository viajeroRepository = new ViajeroRepository();
        Viajero viajero = new Viajero(1L, "Eliana Navarro");
        viajeroRepository.addViajero(viajero);

        List<Reserva> paqueteCompleto = Arrays.asList(
                new Reserva("Hotel", 200.0),
                new Reserva("Comida", 100.0),
                new Reserva("Boletos", 150.0),
                new Reserva("Transporte", 50.0)
        );

        Localizador paqueteCompletoLocalizador = new Localizador(viajero, paqueteCompleto);
        viajero.agregarLocalizador(paqueteCompletoLocalizador);
        paqueteCompletoLocalizador.printDetalle();

        List<Reserva> hotelAndTickets = Arrays.asList(
                new Reserva("Hotel", 200.0),
                new Reserva("Hotel", 200.0),
                new Reserva("Boletos", 150.0),
                new Reserva("Boletos", 150.0)
        );

        Localizador hotelYBoletosLocalizador = new Localizador(viajero, hotelAndTickets);
        viajero.agregarLocalizador(hotelYBoletosLocalizador);
        hotelYBoletosLocalizador.printDetalle();

        Reserva reserva = new Reserva("Hotel", 200.0);
        Localizador unaResevaLocalizador = new Localizador(viajero, List.of(reserva));

        Map<String, List<Localizador>> localizadores = Map.of(
                "1", viajero.getLocalizadores()
        );
        LocalizadorRepository localizadorRepository = new LocalizadorRepository(localizadores);

        viajero.agregarLocalizador(unaResevaLocalizador);
        unaResevaLocalizador.printDetalle();

        System.out.println("Locators Totales vendidos: " + localizadorRepository.getLocalizadoresVendidos());
        System.out.println("Cantidad de reservas realizadas: " +localizadorRepository.getCantidadReservas());
    }
}
