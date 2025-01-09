package com.meli.model;

import java.util.List;

public class Factura {

    private Cliente cliente;
    private List<Producto> productos;
    private Double totalCompra;

    public Factura(Cliente cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
        this.calculateTotalCompra();
    }

    private void calculateTotalCompra() {
        this.setTotalCompra(this.productos.stream().mapToDouble(p -> p.getTotal()).sum());
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
        this.calculateTotalCompra();
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    private void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }
}
