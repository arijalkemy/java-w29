package com.example;

import com.example.entities.Cliente;
import com.example.entities.Reserva;
import com.example.enums.TipoReserva;
import com.example.repositories.ClienteRepository;
import com.example.repositories.ClienteRepositoryImpl;
import com.example.repositories.LocalizadorRepository;
import com.example.repositories.LocalizadorRepositoryImpl;
import com.example.services.ClienteService;
import com.example.services.ClienteServiceImpl;
import com.example.services.LocalizadorService;
import com.example.services.LocalizadorServiceImpl;

import java.text.DecimalFormat;
import java.util.List;

public class Main {

    private final static String AZUL = "\u001B[34m";

    private final static String RESET = "\u001B[0m";

    private final static String DIV = "-------------------------------";

    public static void main(String[] args) {

        ClienteRepository clienteRepository = new ClienteRepositoryImpl();
        ClienteService clienteService = new ClienteServiceImpl(clienteRepository);
        LocalizadorRepository localizadorRepository = new LocalizadorRepositoryImpl();
        LocalizadorService localizadorService = new LocalizadorServiceImpl(localizadorRepository);

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
