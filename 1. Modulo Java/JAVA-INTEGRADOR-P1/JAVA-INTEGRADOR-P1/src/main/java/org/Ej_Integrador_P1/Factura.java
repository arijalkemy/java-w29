package org.Ej_Integrador_P1;

import java.util.List;

// Clase Factura
class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double total;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        calcularTotal();
    }

    private void calcularTotal() {
        total = items.stream().mapToDouble(item -> item.getCantidad() * item.getCostoUnitario()).sum();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "Cliente=" + cliente +
                ", Items=" + items +
                ", Total=" + total +
                '}';
    }
}
