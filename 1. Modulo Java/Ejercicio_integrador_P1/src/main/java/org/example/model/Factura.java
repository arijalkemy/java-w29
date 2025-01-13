package org.example.model;

import java.util.List;

public class Factura {
    private Long codigo;
    private Cliente cliente;
    private List<Item> listaItems;
    private double total;

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

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Factura(Long codigo, Cliente cliente, List<Item> listaItems, double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.total = total;
    }

    public Factura() {
    }
}
