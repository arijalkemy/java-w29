import java.util.*;

public class ClientRepository {

    private Map<Client, List<Locator>> locatorsByClient;

    public ClientRepository() {
        locatorsByClient = new HashMap<>();
    }

    public void addClient(Client client) {
        locatorsByClient.putIfAbsent(client, new ArrayList<>());
    }

    public void addLocator(Locator locator) {
        locatorsByClient.putIfAbsent(locator.getClient(), new ArrayList<>());
        List<Locator> clientLocators = locatorsByClient.get(locator.getClient());

        applyDiscount(clientLocators, locator);
        clientLocators.add(locator);

        System.out.printf("--- Added new locator for %s ---%n", locator.getClient().getFirstname());
        locator.getBookings().forEach(System.out::println);
    }

    public void remove(Locator locator) {
        List<Locator> locators = locatorsByClient.getOrDefault(locator.getClient(), new ArrayList<>());
        locators.remove(locator);

        System.out.printf("--- Removed locator for %s ---%n", locator.getClient().getFirstname());
        locator.getBookings().forEach(System.out::println);
    }

    public void getDetails(Client client) {
        System.out.printf("--- Details for %s ---%n", client.getFirstname());

        List<Locator> clientLocators = locatorsByClient.getOrDefault(client, new ArrayList<>());
        clientLocators.forEach(System.out::println);


    }

    private void applyDiscount(List<Locator> locators, Locator newLocator) {
        // If there were 2 locators => Apply 5% discount
        if (locators.size() >= 2) {
            newLocator.addDiscount(0.05);
        }
        if (new HashSet<>(newLocator.getBookings().stream().map(Booking::getType).toList()).containsAll(List.of(Booking.Type.HOTEL, Booking.Type.FOOD, Booking.Type.TICKET, Booking.Type.TRANSPORT))) {
            newLocator.addDiscount(0.1);
        }
        if (newLocator.getBookings().stream().filter(b -> b.getType().equals(Booking.Type.HOTEL)).toList().size() == 2
                || newLocator.getBookings().stream().filter(b -> b.getType().equals(Booking.Type.TICKET)).toList().size() == 2) {
            newLocator.addDiscount(0.05);
        }
    }

}
