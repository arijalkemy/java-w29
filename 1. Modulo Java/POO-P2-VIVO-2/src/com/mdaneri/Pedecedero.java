package com.mdaneri;

public class Pedecedero extends Producto {

    private int diasPorCaducar;

    public Pedecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidad) {
        double descuento = switch (diasPorCaducar) {
            case 1 -> 4;
            case 2 -> 3;
            case 3 -> 2;
            default -> 1;
        };
        return cantidad * (getPrecio() / descuento);
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Pedecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

}
