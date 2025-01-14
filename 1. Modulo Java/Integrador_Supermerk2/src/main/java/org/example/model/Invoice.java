package org.example.model;

import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.random.RandomGeneratorFactory;

public class Invoice {

    private int id;
    private Client client;
    private List<Item> items;
    private int total;

    public Invoice(int id, Client client, List<Item> items, int total) {
        this.id = id;
        this.client = client;
        this.items = items;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    private void setId(int id){
        this.id = id;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "client=" + client +
                ", items=" + items +
                ", total=" + total +
                '}';
    }

}
