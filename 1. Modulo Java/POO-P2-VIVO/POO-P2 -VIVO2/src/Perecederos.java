public class Perecederos extends Producto {
    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecederos(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
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

    @Override
    public double calcular(int cantidadDeProductos) {
        double descuento = 0;

        switch (diasPorCaducar){
            case 1:
                descuento = getPrecio() / 4;
                return super.calcular(cantidadDeProductos) - descuento;
            case 2:
                descuento = getPrecio() / 3;
                return super.calcular(cantidadDeProductos) - descuento;
            case 3:
                descuento = getPrecio() / 2;
                return super.calcular(cantidadDeProductos) - descuento;
            default:
                return super.calcular(cantidadDeProductos);
        }
    }
}
