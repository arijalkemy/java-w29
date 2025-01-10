package org.example.model;

public class Booking {
    private final BookingType bookingType;
    private final Double price;

    public Booking(BookingType bookingType, Double price) {
        this.bookingType = bookingType;
        this.price = price;
    }

    public BookingType getBookingType() {
        return bookingType;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String
    toString() {
        return "Booking{" +
                "bookingType=" + bookingType +
                ", price=" + price +
                '}';
    }
}
