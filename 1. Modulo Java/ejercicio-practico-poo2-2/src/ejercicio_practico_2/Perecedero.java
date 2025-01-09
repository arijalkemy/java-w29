package ejercicio_practico_2;

public class Perecedero extends Producto {
    private int  diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre,precio);
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

    public double calcular(int cantidadProductos){
        double precio = super.calcular(cantidadProductos);

        switch(diasPorCaducar){
            case 1: return precio/4;
            case 2: return precio/3;
            case 3: return precio/2;
        }

        return precio;
    }
}
