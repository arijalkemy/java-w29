package Ejercicio2_DistriProduc;

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
        return "Perecedero [nombre=" + getNombre() + ", precio=" + getPrecio() + ", diasPorCaducar=" + diasPorCaducar + "]";
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double total = super.calcular(cantidadDeProductos);
        if (diasPorCaducar == 1) {
            total /= 4; // Reduce 4 veces el precio
        } else if (diasPorCaducar == 2) {
            total /= 3; // Reduce 3 veces el precio
        } else if (diasPorCaducar == 3) {
            total /= 2; // Reduce a la mitad
        }
        return total;
    }
}