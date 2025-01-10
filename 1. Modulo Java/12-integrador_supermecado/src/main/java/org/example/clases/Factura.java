package org.example.clases;

import java.util.ArrayList;
import java.util.List;

//las facturas que se generan cuando un cliente hace una compra contienen a un cliente,
// una lista de ítems y el total de la compra.
public class Factura {
    private Integer id;
    Cliente cliente;
    List<Item> items;
    private double total;

    //constructores

    public Factura() {
    }

    public Factura(Integer id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
        this.items = new ArrayList<>();
        this.total = 0;
    }

    //getters y setters

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
        return total;
    }


    //agregar items
    public void addItem(Item item) {
        this.items.add(item);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    //to string

    @Override
    public String toString() {
        return "Factura["+ cliente.toString() + items.toString() +
                ", total=" + total +
                ']';
    }

    //calcular total
    public void calcularTotal(Factura factura) {
        factura.getItems().forEach(item -> {
            total += item.getCostoUnit() * item.getCatidad();
        });
    }
}
