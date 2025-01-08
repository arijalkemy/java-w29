package ejercicio2;

public class Perecedero extends Producto {

    private Integer diasPorCaducar;

    public Perecedero(String nombre, Double precio, Integer diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public Integer getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(Integer diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public Double calcular(int cantidadDeProductos) {
        Double precio = super.calcular(cantidadDeProductos);
        if (diasPorCaducar == 1) {
            return precio / 4;
        } else if (diasPorCaducar == 2) {
            return precio / 3;
        } else if (diasPorCaducar == 3) {
            return precio / 2;
        } else {
            return precio;
        }
    }

}
