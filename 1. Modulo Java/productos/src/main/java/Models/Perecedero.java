package Models;

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
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioTemp = 0;
        if(diasPorCaducar == 1){
            precioTemp = precio / 4;
        }else if(diasPorCaducar == 2){
            precioTemp = precio / 3;
        } else if (diasPorCaducar == 3) {
            precioTemp = precio / 2;
        }
        return super.calcular(cantidadDeProductos);
    }
}
