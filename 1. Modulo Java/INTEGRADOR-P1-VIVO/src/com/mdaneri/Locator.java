package com.mdaneri;

import java.util.ArrayList;
import java.util.List;

public class Locator {

    private Client client;
    private List<Booking> bookings;
    private Double discount;
    private Double totalCost;


    public Locator(Client client) {
        this.client = client;
        this.bookings = new ArrayList<>();
        this.totalCost = 0d;
        this.discount = 0d;
    }

    public Double getDiscount() {
        return discount;
    }

    public void addDiscount(Double discount) {
        this.discount += discount;
    }

    public Client getClient() {
        return client;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public Double getTotalCost() {
        return totalCost * (1 - discount);
    }

    public void add(Booking booking) {
        bookings.add(booking);
        totalCost += booking.getCost();
    }

    public void remove(Booking booking) {
        bookings.remove(booking);
        totalCost -= booking.getCost();
    }

    @Override
    public String toString() {
        return "Locator{" +
                "client=" + client +
                ", bookings=" + bookings +
                ", discount=" + discount +
                ", totalCost=" + totalCost +
                '}';
    }
}
