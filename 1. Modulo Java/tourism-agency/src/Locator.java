import java.util.List;

public class Locator {
    private Client client;
    private List<Booking> bookings;
    private Double total;

    // Constructor
    public Locator(Client client, List<Booking> bookings, Double total) {
        this.client = client;
        this.bookings = bookings;
        this.total = total;
    }

    @Override
    public String toString() {
        return "Locator - Client" +
            client.toString() +
            "\nBookings: " +
            bookings.toString() +
            "\nTotal: " +
            total;
    }

    static List<Booking> getFullBooking() {
        return List.of(
                new Booking(Booking.BookingType.HOTEL),
                new Booking(Booking.BookingType.FOOD),
                new Booking(Booking.BookingType.TRIP),
                new Booking(Booking.BookingType.TRANSPORT)
        );
    }

    // Getters and setters
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
