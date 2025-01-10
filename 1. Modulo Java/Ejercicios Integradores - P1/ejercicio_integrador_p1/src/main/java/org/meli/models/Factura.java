package org.meli.models;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.total = calcularTotal();
    }

    private double calcularTotal() {
        return items.stream().mapToDouble(Item::calcularCostoTotal).sum();
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}
