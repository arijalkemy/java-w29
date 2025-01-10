package com.example;

import com.example.model.Cliente;
import com.example.model.Reserva;
import com.example.model.TipoReserva;
import com.example.repository.LocalizadorRepositoryImpl;
import com.example.service.ClienteService;
import com.example.service.LocalizadorService;

import java.text.DecimalFormat;
import java.util.List;

public class Main {

    private final static String AZUL = "\u001B[34m";

    private final static String RESET = "\u001B[0m";

    private final static String DIV = "-------------------------------";

    public static void main(String[] args) {

        LocalizadorRepositoryImpl localizadorRepository = new LocalizadorRepositoryImpl();
        ClienteService clienteService = new ClienteService();
        LocalizadorService localizadorService = new LocalizadorService(localizadorRepository);

        // PARTE 1
        Cliente nuevoCliente = clienteService.crearCliente("Agostina");

        Reserva hotel = new Reserva(TipoReserva.HOTEL, 100);
        Reserva comida = new Reserva(TipoReserva.COMIDA, 50);
        Reserva boleto = new Reserva(TipoReserva.BOLETO, 150);
        Reserva transporte = new Reserva(TipoReserva.TRANSPORTE, 80);

        System.out.println(AZUL + "\nPARTE 1\n" + DIV + RESET);
        System.out.println(AZUL + "Localizador por paquete completo:" + RESET);
        System.out.println(localizadorService.crearLocalizador(nuevoCliente, List.of(hotel, comida, boleto, transporte)));

        System.out.println(AZUL + "\nLocalizador con 2 reservas de hotel y 2 reservas de boleto" + RESET);
        System.out.println(localizadorService.crearLocalizador(nuevoCliente, List.of(hotel, hotel, boleto, boleto)));

        System.out.println(AZUL + "\nLocalizador con una sola reserva" + RESET);
        System.out.println(localizadorService.crearLocalizador(nuevoCliente, List.of(transporte)));

        // PARTE 2
        System.out.println(AZUL + "\n\nPARTE 2\n" + DIV + RESET);
        System.out.print(AZUL + "Cantidad de localizadores ventidos: " + RESET);
        System.out.println(localizadorService.getCantidadLocalizadoresVendidos());

        System.out.print(AZUL + "Cantidad total de reservas: " + RESET);
        System.out.println(localizadorService.getTotalReservas());

        System.out.println(AZUL + "Diccionario de todas las reservas clasificadas:" + RESET);

        localizadorService.getReservasByTipo().forEach((tipo, lista) -> {
            System.out.println("\t - " + tipo + ": " + lista);
        });

        System.out.print(AZUL + "Total de ventas: " + RESET + " $");
        System.out.println(localizadorService.getTotalVentas());

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.print(AZUL + "Promedio de todas las ventas: " + RESET + " $");
        System.out.println(df.format(localizadorService.getPromedioVentas()));
    }

}
