package Ejercicio2;

public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(String name, double price, int diasPorCaducar) {
        super(name, price);
        this.diasPorCaducar = diasPorCaducar;
    }
    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }
    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double result = this.getPrice() * cantidadDeProductos;
        if (this.getDiasPorCaducar() == 1) result = result/4;
        if (this.getDiasPorCaducar() == 2) result = result/3; 
        if (this.getDiasPorCaducar() == 3) result = result/2; 
        return result;
    }
    
}
