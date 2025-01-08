package org.example;

public class Perecedero extends Producto{
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
    public double calcular(int cantidadDeProductos) {
        double precio = super.calcular(cantidadDeProductos);
        switch (this.diasPorCaducar) {
            case 1 -> precio /= 4;
            case 2 -> precio /= 3;
            case 3 -> precio /= 2;
        }
        return precio;
    }

    @Override
    public String toString() {
        return super.toString() + "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
