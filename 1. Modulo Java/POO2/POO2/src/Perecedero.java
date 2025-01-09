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
    public double calcular(int cantidadDeProductos) {
        double precioInicial = super.getPrecio();
        double precioFinal=0.00;
        switch (diasPorCaducar) {
            case 1:
                 precioFinal = (precioInicial / 4) * cantidadDeProductos;
                break;
            case 2:
                precioFinal = (precioInicial / 3) * cantidadDeProductos;;
                break;
            case 3:
                precioFinal = (precioInicial / 2) * cantidadDeProductos;;
                break;
            default:
                super.calcular(cantidadDeProductos);
                break;
        }
        return precioFinal;
    }

    @Override
    public String toString() {
        return "Producto perecedero:\n" +
                "diasPorCaducar=" + diasPorCaducar +
                "\nnombre=" + getNombre() +
                "\nprecio=" + getPrecio() +
                "\n";
    }
}