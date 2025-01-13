package com.example.demo.integradores.agencia_turismo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ClientRepository repository = new ClientRepository();
        Client client = new Client("1", "Eliseo Sanz");
        repository.addClient(client);

        List<Reservation> fullPackage = Arrays.asList(
                new Reservation("Hotel", 200),
                new Reservation("Comida", 100),
                new Reservation("Boletos", 150),
                new Reservation("Transporte", 50)
        );

        Locator fullPackageLocator = new Locator(client, fullPackage); // Cliente y List<Reservation>
        client.addLocator(fullPackageLocator); // Cliente con lista de Locators
        fullPackageLocator.printDetails();

        List<Reservation> hotelAndTickets = Arrays.asList(
                new Reservation("Hotel", 200),
                new Reservation("Hotel", 200),
                new Reservation("Boletos", 150),
                new Reservation("Boletos", 150)
        );

        Locator hotelAndTicketsLocator = new Locator(client, hotelAndTickets);
        client.addLocator(hotelAndTicketsLocator);
        hotelAndTicketsLocator.printDetails();

        Reservation reserva = new Reservation("Hotel", 200); // 9 ! ! ! !
        Locator singleReservaLocator = new Locator(client, List.of(reserva));

        Map<String, List<Locator>> locators = Map.of(
                "1", client.getLocators()
        );
        LocatorRepository locatorRepository = new LocatorRepository(locators);

        client.addLocator(singleReservaLocator); // Son todas del mismo cliente
        singleReservaLocator.printDetails();  // muestra $190.0 por el 5% Off



        System.out.println("Locators Totales vendidos: " + locatorRepository.getLocatorsSold());
        System.out.println("Cantidad de reservas realizadas: " +locatorRepository.getQuantityReservations());
    }
}
