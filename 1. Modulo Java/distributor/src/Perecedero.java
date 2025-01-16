public class Perecedero extends Producto {
    int diasPorCaducar;

    // Constructors
    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    // Methods
    @Override
    public String toString() {
        return super.toString() + " Dias por caducar: " + diasPorCaducar + ".";
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double totalAmount = super.calcular(cantidadDeProductos);
        // Enhanced switch not supported for java 11
        switch (diasPorCaducar) {
            case 1: 
                totalAmount /= 4;
                break;
            case 2:
                totalAmount /= 3;
                break;
            case 3:
                totalAmount /= 2;
                break;
        };

        return totalAmount;
    }

    // Getters
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    // Setters
    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
