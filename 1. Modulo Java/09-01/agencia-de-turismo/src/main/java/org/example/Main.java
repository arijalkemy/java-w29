package org.example;

import org.example.model.Booking;
import org.example.model.BookingType;
import org.example.model.Client;
import org.example.service.ClientService;
import org.example.service.LocatorService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private final static String AZUL = "\u001B[34m";

    private final static String RESET = "\u001B[0m";

    private final static String DIV = "-------------------------------";

    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        LocatorService locatorService = new LocatorService();

        // Part 1
        Client client = new Client("Martín");

        Booking hotel = new Booking(BookingType.HOTEL, 1200.00);
        Booking ticket = new Booking(BookingType.TICKET, 600.00);
        Booking food = new Booking(BookingType.FOOD, 350.00);
        Booking transport = new Booking(BookingType.TRANSPORT, 150.00);

        System.out.println(AZUL + "\nPARTE 1\n" + DIV + RESET);
        System.out.println(AZUL + "Localizador por paquete completo:" + RESET);
        locatorService.save(client, List.of(hotel, ticket, food, transport));
        locatorService.getLocators().forEach(System.out::println);
    }
}