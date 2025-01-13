package org.example.model;

import java.util.List;

public class Invoice {
    /**
     * Attributes
     */
    private Long code;
    private Client client;
    private List<Item> items;
    private double total;

    /**
     * Constructor
     */
    public Invoice(Long code, Client client, List<Item> items) {
        this.code = code;
        this.client = client;
        this.items = items;
        calculateTotalItems();
    }

    /**
     * Getters and setters
     */
    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void calculateTotalItems() {
        this.total = this.items.stream()
                .mapToDouble(item -> item.getQuantity() * item.getUnitPrice())
                .sum();
    }

    @Override
    public String toString() {
        return "Invoice --" +
                "client=" + client +
                "\nitems=" + items +
                "\ntotal=" + total;
    }
}
