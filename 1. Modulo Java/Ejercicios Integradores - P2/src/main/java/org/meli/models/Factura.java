package org.meli.models;

import java.util.List;

public class Factura {
    private String id;
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(String id, Cliente cliente, List<Item> items) {
        this.id = id;
        this.cliente = cliente;
        this.items = items;
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        return items.stream().mapToDouble(Item::getSubtotal).sum();
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }
}
