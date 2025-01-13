package ejercicio2.domain;

public class Perecedero extends Producto {
    int diasPorCaducar;

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
    public int calcular(int cantidadDeProductos) {
        int divisor = switch (diasPorCaducar) {
            case 1 -> 4;
            case 2 -> 3;
            case 3 -> 2;
            default -> 1;
        };
        return (int) (cantidadDeProductos * super.getPrecio()) / divisor;
    }

    @Override
    public String toString() {
        return super.toString() + "\nDías Por Caducar: " + diasPorCaducar;
    }
}
