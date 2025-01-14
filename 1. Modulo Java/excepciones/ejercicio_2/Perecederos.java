package ejercicio_2;

public class Perecederos extends Producto {
    public int diasPorCaducar;

    public Perecederos(String nombre, Double precio, int diasPorCaducar) {
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
        return "Perecederos{" +
                "precio=" + precio +
                ", diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public Double Calcular(int CantidadDeProductos) {
        if(diasPorCaducar == 1){
            precio = precio / 4;
        } else if(diasPorCaducar == 2){
            precio = precio / 3;
        } else if(diasPorCaducar == 3){
            precio = precio / 2;
        }

        return precio * (CantidadDeProductos);
    }
}

