public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double tempPrecio = cantidadDeProductos * getPrecio();
        return switch (diasPorCaducar) {
            case 1 -> tempPrecio / 4;
            case 2 -> tempPrecio / 3;
            case 3 -> tempPrecio / 2;
            default -> tempPrecio;
        };
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
                "nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() +
                ", diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
