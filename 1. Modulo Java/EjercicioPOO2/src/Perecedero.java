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
        return "Pedecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {

        double montoPrecio = super.calcular(cantidadDeProductos);

        if (diasPorCaducar == 1) {
            montoPrecio -= montoPrecio * 0.75;
        } else if (diasPorCaducar == 2) {
            montoPrecio -= montoPrecio * 0.66;
        } else if (diasPorCaducar == 3) {
            montoPrecio /= 2;
        }

        return montoPrecio;

    }
}
