import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // 1st part
        Client homer = new Client(12345678, "Homer Simpson");
        RepositoryClient repositoryClient = new RepositoryClient(homer);

        Locator completeLocator = new Locator(homer, Locator.getFullBooking(), 100.0);
        repositoryClient.addLocator(completeLocator);

        List<Booking> hotelAndTripBookings = List.of(
                new Booking(Booking.BookingType.TRIP),
                new Booking(Booking.BookingType.TRIP),
                new Booking(Booking.BookingType.HOTEL),
                new Booking(Booking.BookingType.HOTEL));
        Locator hotelAndTripLocator = new Locator(homer, hotelAndTripBookings, 200.0);
        repositoryClient.addLocator(hotelAndTripLocator);

        Locator foodLocator = new Locator(homer, List.of(new Booking(Booking.BookingType.FOOD)), 10.0);
        repositoryClient.addLocator(foodLocator);

        repositoryClient.printLocators();

        // 2nd part
        LocatorChecker locatorChecker = new LocatorChecker(repositoryClient);

        System.out.println("Total amount of selled locators: " + locatorChecker.getAmountOfLocators());
        System.out.println("Total amount of bookings: " + locatorChecker.getTotalAmountOfBookings());
        System.out.println("All bookings: " + locatorChecker.getTotalBookingsByType());
        System.out.println("Total selled: " + locatorChecker.getTotalSelled());
        System.out.println("Total selled average: " + locatorChecker.getTotalSelledAvg());
    }
}