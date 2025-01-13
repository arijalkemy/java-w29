package P2.exercise2.domain;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidad) {
        double precio = this.precio * cantidad;
        switch (this.diasPorCaducar){
            case 1 -> precio = precio/4;
            case 2 -> precio = precio/3;
            case 3 -> precio = precio/2;
        }
        return precio;
    }
}
