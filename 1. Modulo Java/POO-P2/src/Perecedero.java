public class Perecedero extends Producto{

    int diasPorCaducar = 0;

    public Perecedero(String nombre, Double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        if(diasPorCaducar == 1){
            precio = precio - precio * 4;
        }else if(diasPorCaducar == 2){
            precio = precio - precio * 3;
        }else{
            precio = precio / 2;
        }
        return precio * cantidadDeProductos;
    }

    public Perecedero(String nombre, Double precio) {
        super(nombre, precio);
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
