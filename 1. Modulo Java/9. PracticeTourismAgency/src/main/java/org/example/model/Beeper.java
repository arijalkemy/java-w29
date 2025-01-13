package org.example.model;

import java.util.List;

public class Beeper {
    /**
     * Attributes
     */
    private Long id;
    private Client client;
    private double price;
    private List<Booking> bookings;

    /**
     * Constructor
     * @param id Identification of beeper
     * @param client Client of beeper
     * @param bookings List of bookings
     */
    public Beeper(Long id, Client client, List<Booking> bookings) {
        this.id = id;
        this.client = client;
        this.bookings = bookings;
        this.price = calculatePrice();
    }

    /**
     * Getters and setters
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public double calculatePrice() {
        double total = 0;
        for (Booking booking : bookings) {
            total += booking.getPrice();
        }
        return total;
    }

    private double getNewPrice(Booking booking) {
        return booking.getPrice() - (booking.getPrice()) * 0.05;
    }

    public void validateAmountOfBookings() {
        long hotel = bookings.stream()
                .filter(booking -> booking.getType().equals(TypeBooking.HOTEL))
                .count();

        long travel = bookings.stream()
                .filter(booking -> booking.getType().equals(TypeBooking.TRAVEL_TICKETS))
                .count();

        if (hotel >= 2) {
            bookings.stream()
                    .filter(booking -> booking.getType().equals(TypeBooking.HOTEL))
                    .forEach(booking -> booking.setPrice(getNewPrice(booking)));
        }

        if (travel >= 2) {
            bookings.stream()
                    .filter(booking -> booking.getType().equals(TypeBooking.TRAVEL_TICKETS))
                    .forEach(booking -> booking.setPrice(getNewPrice(booking)));
        }
        this.price = calculatePrice();
    }

    public void applyDiscount(double discount) {
        this.price -= this.price * discount;
    }

    @Override
    public String toString() {
        return "Beeper ==== " +
                "id: " + id +
                "\nClient: " + client +
                "\nPrice=: " + price +
                "\nBookings: " + bookings;
    }
}
