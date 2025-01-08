package org.example;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    private List<Producto> productos = new ArrayList<>();

    public Distribuidora(List<Producto> productos){
        this.productos = productos;
    }

    public double imprimirPrecio(int cantidadDeProductos){
        double precioFinal = 0.0;
        for(Producto p : this.productos){
            precioFinal += p.calcular(cantidadDeProductos);
        }
        return precioFinal;
    }
}
