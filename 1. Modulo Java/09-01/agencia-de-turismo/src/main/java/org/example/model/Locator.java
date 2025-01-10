package org.example.model;

import java.util.List;

public class Locator {
    private static Long lastId = 0L;

    private Long id;
    private Client client;
    private List<Booking> bookings;
    private Double totalPrice;

    public Locator(Client client, List<Booking> bookings, Double totalPrice) {
        id = ++lastId;
        this.client = client;
        this.bookings = bookings;
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Locator{" +
                "id=" + id +
                ", client=" + client +
                ", bookings=" + bookings +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
