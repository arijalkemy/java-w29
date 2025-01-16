public class Booking {
    public enum BookingType {
        HOTEL,
        FOOD,
        TRIP,
        TRANSPORT
    }

    private BookingType type;

    // Constructor
    public Booking(BookingType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Booking - " + type;
    }

    // Getters and setters
    public BookingType getType() {
        return type;
    }

    public void setType(BookingType type) {
        this.type = type;
    }
}
