package ejercicio_2;

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
    public Double calcular(Integer cantidadDeProductos) {
        Double precioFinal = super.calcular(cantidadDeProductos);

        switch (diasPorCaducar) {
            case 1:
                return precioFinal / 4;
            case 2:
                return precioFinal / 3;
            case 3:
                return precioFinal / 2;
            default:
                return precioFinal;
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Perecedero [diasPorCaducar=" + diasPorCaducar + "]";
    }
}




