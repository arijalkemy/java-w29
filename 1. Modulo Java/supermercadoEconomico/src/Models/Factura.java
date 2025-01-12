package Models;

import java.util.List;

public class Factura {
    private int id;
    private Cliente cliente;
    private List<Item> items;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        this.items = items;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Double getTotal() {
        return this.items.stream().mapToDouble(Item::getTotalPrice).sum();
    }

    @Override
    public String toString() {
        return "Models.Factura{" +
                ", items=" + items +
                ", \ncliente=" + cliente.toString() +
                ", \ntotal=}" + getTotal();
    }
}
