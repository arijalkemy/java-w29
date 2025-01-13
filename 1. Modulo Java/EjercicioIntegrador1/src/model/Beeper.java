package model;

import java.util.List;

public class Beeper {
    private Client client;
    private List<Booking> bookingList;
    private Double total;

    public Beeper(Client client, List<Booking> bookingList) {
        this.client = client;
        this.bookingList = bookingList;
        calculateTotal();
    }

    public void applyDiscount(Double percentage) {
        this.total *= percentage;
    }

    private void calculateTotal() {
        this.total = bookingList.stream().mapToDouble(Booking::getPrice).sum();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(List<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Beeper{" +
                "client=" + client +
                ", bookingList=" + bookingList +
                ", total=" + total +
                '}';
    }
}
