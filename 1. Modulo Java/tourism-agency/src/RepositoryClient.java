import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class RepositoryClient extends Repository {
    private Client client;

    public RepositoryClient(Client client) {
        super(new ArrayList<>());
        this.client = client;
    }

    @Override
    public void addLocator(Locator locator) {
        if (locator.getClient().equals(client)) {
            locator.setTotal(locator.getTotal() * (1 - calculateDiscount(locator)));
            super.addLocator(locator);
        }
    }

    private Double calculateDiscount(Locator locator) {
        double discount = 0.0;
        discount += previousLocatorsDiscount();
        discount += fullPackageDiscount(locator);
        discount += multipleBookingsDiscount(locator);
        return discount;
    }

    private double previousLocatorsDiscount() {
        return getLocators().size() > 1 ? 0.05 : 0.0;
    }

    private double fullPackageDiscount(Locator locator) {
        List<Booking.BookingType> fullBookingTypes = Locator.getFullBooking().stream()
                .map(Booking::getType)
                .toList();

        List<Booking.BookingType> bookingTypes = locator.getBookings().stream()
                .map(Booking::getType)
                .toList();

        return bookingTypes.containsAll(fullBookingTypes) ? 0.10 : 0.0;
    }

    private double multipleBookingsDiscount(Locator locator) {
        Map<Booking.BookingType, Long> bookingCounts = locator.getBookings().stream()
                .collect(Collectors.groupingBy(Booking::getType, Collectors.counting()));

        boolean hasDiscount = bookingCounts.getOrDefault(Booking.BookingType.HOTEL, 0L) >= 2 ||
                bookingCounts.getOrDefault(Booking.BookingType.TRIP, 0L) >= 2;

        return hasDiscount ? 0.05 : 0.0;
    }
}