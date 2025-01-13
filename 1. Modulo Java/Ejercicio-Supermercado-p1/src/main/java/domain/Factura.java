package domain;

import java.util.ArrayList;
import java.util.List;

class Factura {
    private final Cliente cliente;
    private final List<Item> items;
    private double total;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
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
}
