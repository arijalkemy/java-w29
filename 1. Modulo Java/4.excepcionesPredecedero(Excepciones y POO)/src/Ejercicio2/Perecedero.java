package Ejercicio2;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String nombre, double precio,int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;


    }

    @Override
    public double calcular(double numDeProductos) {
        double calc = super.calcular(numDeProductos);
        switch(diasPorCaducar){
            case 1 -> calc = calc / 4 ;
            case 2 -> calc = calc / 3 ;
            case 3 -> calc = calc / 2 ;
        }
        return calc;
    }

    @Override
    public String toString() {
        return super.toString() +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
