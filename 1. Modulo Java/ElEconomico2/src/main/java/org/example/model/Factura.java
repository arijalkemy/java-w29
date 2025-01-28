package org.example.model;
import java.util.*;

public class Factura {
    private Long codigo;
    private Cliente cli;
    private List<Item> listaItems;
    private Double total;

    public Factura() {
    }

    public Factura(Long codigo, Cliente cli, List<Item> listaItems, Double total) {
        this.codigo = codigo;
        this.cli = cli;
        this.listaItems = listaItems;
        this.total = total;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCli() {
        return cli;
    }

    public void setCli(Cliente cli) {
        this.cli = cli;
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

    @Override
    public String toString() {
        return "Factura{" +
                "codigo=" + codigo +
                ", cli=" + cli.toString() +
                ", listaItems=" + listaItems +
                ", total=" + total +
                '}';
    }
}
