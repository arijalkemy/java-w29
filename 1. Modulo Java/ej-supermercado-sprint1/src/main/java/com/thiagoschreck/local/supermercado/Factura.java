package com.thiagoschreck.local.supermercado;

import java.util.List;

public class Factura {
    private Cliente cliente;
    private List<Producto> compra;

    public Factura(Cliente cliente, List<Producto> compra) {
        this.cliente = cliente;
        this.compra = compra;
    }

    public double getTotal() {
        return compra.stream()
                .map(Producto::getTotal)
                .reduce(0.0, Double::sum);
    }
}
