package model;

import java.util.List;

public class Factura {
    private long codigo;
    private Cliente cliente;
    private List<Item> lista;
    private double totalCompra;

    public Factura(long codigo, Cliente cliente, List<Item> lista, double totalCompra) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.lista = lista;
        this.totalCompra = totalCompra;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public List<Item> getLista() {
        return lista;
    }

    public void setLista(List<Item> lista) {
        this.lista = lista;
    }
}
