package org.bootcamp;

import java.util.List;

public class Factura {
    private Integer codigo;
    private Cliente cliente;
    private List<Item> listaItems;
    private Double total;

    public Factura() {

    }

    public Factura(Integer codigo, Cliente cliente, List<Item> listaItems) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.listaItems = listaItems;
        calcularTotal();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    private void calcularTotal() {
        total = listaItems.stream().mapToDouble(Item::calcularCostoTotal).sum();
    }

    @Override
    public String toString() {
        return "Factura{" +
                "codigo=" + codigo +
                ", cliente=" + cliente +
                ", listaItems=" + listaItems +
                ", total=" + total +
                '}';
    }
}
