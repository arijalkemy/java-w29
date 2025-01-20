package org.example;

public class Perecedero extends Producto{
    private int diasPorCaducar;
    public Perecedero(String nombre, float precio, int diasPorCaducar) {
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

        return super.toString() +"Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public float calcular(int qty) {
        switch (diasPorCaducar) {

            case 1: this.setPrecio(this.getPrecio()/4);
            break;
            case 2: this.setPrecio(this.getPrecio()/3);
            break;
            case 3: this.setPrecio(this.getPrecio()/2);
            break;
        }
        return this.getPrecio() * qty;
    }
}
