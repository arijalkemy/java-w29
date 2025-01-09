package org.example;

import java.util.List;

public class Factura {
    private Long codigo;
    private Cliente cliente;
    private List<Item> items;
    private Double total;

    public Factura() {
    }

    public Factura(Long codigo, Cliente cliente, List<Item> items, Double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.items = items;
        this.total = total;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
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
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
