package org.example;

public class Perecedero extends Producto {
    private int diasPorCaducar;
    private int cantidad;

    // Constructor
    public Perecedero(String nombre, double precio, int cantidad, int diasPorCaducar) {
        super(nombre, precio); // Llama al constructor de Producto
        this.diasPorCaducar = diasPorCaducar; // Inicializa el atributo
        this.cantidad = cantidad; // Asigna la cantidad de productos
    }

    // Getters y Setters
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal = super.calcular(cantidadDeProductos); // Llama a calcular() de Producto

        // Reduce el precio según los días por caducar
        if (diasPorCaducar == 1) {
            precioFinal -= precioFinal / 4; // Reduce 4 veces
        } else if (diasPorCaducar == 2) {
            precioFinal -= precioFinal / 3; // Reduce 3 veces
        } else if (diasPorCaducar == 3) {
            precioFinal /= 2; // Reduce a la mitad
        }

        return precioFinal; // Devuelve el precio final ajustado
    }

    @Override
    public String toString() {
        return super.toString() + ", Perecedero [diasPorCaducar=" + diasPorCaducar + "]";
    }
}
