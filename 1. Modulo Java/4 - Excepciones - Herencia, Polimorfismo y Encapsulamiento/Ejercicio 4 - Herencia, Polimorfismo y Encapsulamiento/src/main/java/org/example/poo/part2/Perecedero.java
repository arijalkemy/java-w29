package org.example.poo.part2;

public class Perecedero extends Producto {

    //Ejercicio 2//
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero {" +
                "nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() +
                " diasPorCaducar=" + diasPorCaducar +
                " }";
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal = getPrecio() * cantidadDeProductos;

        switch (diasPorCaducar) {
            case 1 -> {
                return precioFinal / 4;
            }
            case 2 -> {
                return precioFinal / 3;
            }
            case 3 -> {
                return precioFinal / 2;
            }
            default -> {
                return precioFinal;
            }
        }
    }
}
