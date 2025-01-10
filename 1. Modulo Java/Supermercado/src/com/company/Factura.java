package com.company;

import java.util.FormatterClosedException;
import java.util.List;

public class Factura implements ICrud {
    private Integer identificador;
    private List<Item> itemsComprados;
    private Cliente cliente;

    public Double getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Double importeTotal) {
        this.importeTotal = importeTotal;
    }

    private Double importeTotal;


    public Factura() {
    }

    public Factura(Integer identificador, List<Item> itemsComprados, Cliente cliente, Double importeTotal) {
        this.identificador = identificador;
        this.itemsComprados = itemsComprados;
        this.cliente = cliente;
        this.importeTotal = importeTotal;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public List<Item> getItemsComprados() {
        return itemsComprados;
    }

    public void setItemsComprados(List<Item> itemsComprados) {
        this.itemsComprados = itemsComprados;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public Object altaProducto(Object factura) {
        System.out.println("Se dio de alta la Factura: "+factura.toString());
        return factura;
    }

    @Override
    public Object bajaProducto(Object factura) {
        System.out.println("Se dio de baja la Factura: "+factura.toString());
        return factura;
    }

    @Override
    public Object modificacionProducto(Object factura) {
        System.out.println("Se modifico la Factura: "+factura.toString());
        return factura;
    }
}
