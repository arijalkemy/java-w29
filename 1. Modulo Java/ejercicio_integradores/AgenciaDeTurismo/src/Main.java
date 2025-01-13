public class Main {
    public static void main(String[] args) {

        Client c1 = new Client("123", "Matías", "Zapiola");
        Client c2 = new Client("456", "Lucas", "Dell");
        Client c3 = new Client("789", "Eduardo", "Tronador");

        ClientRepository repository = new ClientRepository();

        Locator l1 = new Locator(c1);
        l1.add(new Booking(Booking.Type.FOOD, 10d));
        l1.add(new Booking(Booking.Type.TRANSPORT, 20d));
        l1.add(new Booking(Booking.Type.TICKET, 5d));
        l1.add(new Booking(Booking.Type.TICKET, 5d));

        Locator l2 = new Locator(c1);
        l2.add(new Booking(Booking.Type.FOOD, 5d));
        l2.add(new Booking(Booking.Type.TRANSPORT, 25d));
        l2.add(new Booking(Booking.Type.HOTEL, 30d));
        l2.add(new Booking(Booking.Type.HOTEL, 10d));

        Locator l3 = new Locator(c1);
        l3.add(new Booking(Booking.Type.FOOD, 5d));
        l3.add(new Booking(Booking.Type.TRANSPORT, 25d));
        l3.add(new Booking(Booking.Type.HOTEL, 30d));
        l3.add(new Booking(Booking.Type.TICKET, 30d));

        repository.addLocator(l1);
        repository.addLocator(l2);
        repository.addLocator(l3);

        repository.getDetails(c1);


    }
}