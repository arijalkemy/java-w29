package com.mdaneri.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bill {

    private final Long id;
    private Client client;
    private List<Item> items;
    private Double totalCost;

    public Bill(Long id, Client client) {
        this.id = id;
        this.client = client;
        this.items = new ArrayList<>();
        this.totalCost = 0d;
    }

    public void addItem(Item i) {
        items.add(i);
        totalCost += i.getPrice() * i.getAmount();
    }

    public void removeItem(Item i) {
        items.remove(i);
        totalCost -= i.getPrice() * i.getAmount();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(id, bill.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, items, totalCost);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", client=" + client +
                ", items=" + items +
                ", totalCost=" + totalCost +
                '}';
    }
}
