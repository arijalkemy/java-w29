package org.Ejercicio2;

public class Perecedero extends Producto {
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
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadPrductos) {
        if(getDiasPorCaducar()==1){
            return (cantidadPrductos * getPrecio()/4);
        } else if (getDiasPorCaducar()==2) {
            return (cantidadPrductos * getPrecio()/3);
        } else if (getDiasPorCaducar()==3) {
            return (cantidadPrductos * getPrecio()/2);
        }
        return -1;

    }


}
