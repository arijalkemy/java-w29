package com.example.demo.integradores.el_supermercado;

import java.util.List;

class Invoice {
    private Customer customer;
    private List<Item> items;
    private double total;

    public Invoice(Customer customer, List<Item> items) {
        this.customer = customer;
        this.items = items;
        this.total = items.stream().mapToDouble(item -> item.getQuantity() * item.getUnitCost()).sum();
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }
    public void printDetails() {
        System.out.println("Customer: " + customer.getFirstName());
        System.out.println("Items:");
        items.forEach(item ->
                System.out.println("- " + item.getName() + ": " + item.getQuantity() + " x $" + item.getUnitCost()));
        System.out.println("Total: $" + total);
    }
}