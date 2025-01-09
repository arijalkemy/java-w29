package com.thiagoschreck.local.model;

import java.util.List;

public class Factura {
    private final Cliente cliente;
    private final List<Producto> compra;

    public Factura(Cliente cliente, List<Producto> compra) {
        this.cliente = cliente;
        this.compra = compra;
    }

    public double getTotal() {
        return compra.stream()
                .map(Producto::getTotal)
                .reduce(0.0, Double::sum);
    }

    @Override
    public String toString() {
        return String.format("""
                Cliente: %s
                Productos:
                %s
                Total: $%s
                """,
                cliente,
                compra.stream()
                        .map(Producto::toString)
                        .map(str -> "  * ".concat(str).concat("\n"))
                        .reduce("", String::concat),
                getTotal()
        );
    }
}
