package domain;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    private final Cliente cliente;
    private final List<Item> items;
    private final double total;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
        this.total = calcularTotalFactura();
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

    private double calcularTotalFactura() {
        double total = 0;
        for (Item item : items) {
            total += item.calcularTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "Factura: " + cliente.getNombre() + ", " + total;
    }
}
