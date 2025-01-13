package org.example;

import org.example.controller.repository.BeeperRepository;
import org.example.controller.repository.BeeperService;
import org.example.controller.repository.ClientService;
import org.example.model.Beeper;
import org.example.model.Booking;
import org.example.model.Client;
import org.example.model.TypeBooking;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        BeeperService beeperService = new BeeperService();

        // Fist scenario
        Client client = new Client("Nombre1", "121232", "nombre1@email.com");
        clientService.addClient(client);

        List<Booking> bookings = new ArrayList<>();
        bookings.add(new Booking(1L, TypeBooking.HOTEL, 200));
        bookings.add(new Booking(2L, TypeBooking.RESTAURANT, 300));
        bookings.add(new Booking(3L, TypeBooking.TRAVEL_TICKETS, 500));
        bookings.add(new Booking(4L, TypeBooking.TRANSPORT, 100));

        Beeper beeper = beeperService.addBeeper(client, bookings);
        System.out.println(beeper);

        // Second scenario
        bookings = new ArrayList<>();
        bookings.add(new Booking(5L, TypeBooking.HOTEL, 200));
        bookings.add(new Booking(6L, TypeBooking.HOTEL, 200));
        bookings.add(new Booking(7L, TypeBooking.TRAVEL_TICKETS, 500));
        bookings.add(new Booking(8L, TypeBooking.TRAVEL_TICKETS, 500));

        beeper = beeperService.addBeeper(client, bookings);
        System.out.println(beeper);

        // Third scenario
        bookings = new ArrayList<>();
        bookings.add(new Booking(9L, TypeBooking.TRANSPORT, 100));
        beeper = beeperService.addBeeper(client, bookings);
        System.out.println(beeper);

        List<Beeper> beepers = beeperService.getBeepersByClient(client.getDni());
        beepers.forEach(System.out::println);

        // Optional Part
        System.out.println("========= Report =========");
        System.out.println("========= Beepers sold =========");
        beeperService.getAll().forEach(System.out::println);

        System.out.println("========= Total beepers =========");
        System.out.println(beeperService.getAll().size());

        System.out.println("========= Beepers by type =========");
        beeperService.bookingsByType().forEach((key, value) -> System.out.println(key + " \n " + value));

        System.out.println("========= Total sold =========");
        System.out.println(beeperService.getTotalAllBeepers());

        System.out.println("========= Average sold =========");
        System.out.println(beeperService.getTotalAllBeepers() / beeperService.getAll().size());
    }
}