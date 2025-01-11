package org.excepciones2.model;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String name, double price, int diasPorCaducar) {
        super(name, price);
        this.diasPorCaducar = diasPorCaducar;

    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){

        double totalPrice = this.getPrice()*cantidadDeProductos;

        switch (diasPorCaducar) {
            case 1 -> totalPrice -= totalPrice * 4;
            case 2 -> totalPrice -= totalPrice * 3;
            case 3 -> totalPrice /= 2;
        }
        return Math.max(totalPrice,0);
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

}
