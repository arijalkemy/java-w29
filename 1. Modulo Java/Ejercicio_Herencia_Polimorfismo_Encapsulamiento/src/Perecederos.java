public class Perecederos extends Productos {
    int diasXCaducar;

    public Perecederos(String nombre, double precio, int dias) {
        super(nombre, precio);
        this.diasXCaducar = dias;
    }

    public int getDiasXCaducar() {
        return diasXCaducar;
    }

    public void setDiasXCaducar(int diasXCaducar) {
        this.diasXCaducar = diasXCaducar;
    }

    @Override
    public String toString() {
        return "Perecederos{" +
                "diasXCaducar=" + diasXCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal = precio * cantidadDeProductos;

        switch (diasXCaducar) {
            case 1 -> {
                return precioFinal / 4;
            }
            case 2 -> {
                return precioFinal / 3;
            }
            case 3 -> {
                return precioFinal / 2;
            }
            default -> {
                return precioFinal;
            }
        }
    }
}
