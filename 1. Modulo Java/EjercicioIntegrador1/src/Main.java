import model.Client;
import model.Booking;
import enums.Products;
import service.BeeperService;
import service.ClientService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        BeeperService beeperService = new BeeperService();

        Client client = clientService.createClient("John Doe");
        Booking booking1 = new Booking(Products.HOTEL, 100.0);
        Booking booking2 = new Booking(Products.FOOD, 50.0);
        Booking booking3 = new Booking(Products.TICKET, 20.0);
        Booking booking4 = new Booking(Products.TRANSPORT, 30.0);

        System.out.println("Localizador total: " + beeperService.createBeeper(client, List.of(booking1, booking2, booking3, booking4)));
        System.out.println("Localizador de una reserva: " + beeperService.createBeeper(client, List.of(booking1)));
        System.out.println("Localizador con descuento por 2 reservas: " + beeperService.createBeeper(client, List.of(booking1, booking1, booking3, booking3)));


        System.out.println("Cantidad de localizadores vendidos: " + beeperService.getQuantityOfBeepersSold());
        System.out.println("Cantidad de reservas totales: " + beeperService.getTotalBookings());
        System.out.println("Diccionario de reservas clasificadas: ");
        beeperService.getBookingsByType().forEach(
                (type, list) -> System.out.println("\t - " + type + ": " + list)
        );
        System.out.println("Total de ventas: $" + beeperService.getTotal());
        System.out.println("Promedio de ventas: $" + beeperService.getAverage());
    }
}