package org.example;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio); // ctor del padre
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }
    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal = super.calcular(cantidadDeProductos);
        // double precioFinal = this.precio * cantidadDeProductos; // con precio protected

        if (diasPorCaducar == 1) {
            precioFinal /= 4; // Reduce 4 veces
        } else if (diasPorCaducar == 2) {
            precioFinal /= 3; // Reduce 3 veces
        } else if (diasPorCaducar == 3) { precioFinal /= 2; // Reduce a la mitad
        }

        return precioFinal;
    }

    @Override
    public String toString() {
        // llama a toString de Producto
        return super.toString() + ", diasPorCaducar=" + diasPorCaducar;
    }
}
