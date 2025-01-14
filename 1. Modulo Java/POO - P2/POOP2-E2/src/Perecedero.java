public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
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
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
       switch (diasPorCaducar){
           case 1:
               return (cantidadDeProductos * super.getPrecio()/4);
           case 2:
               return (cantidadDeProductos * super.getPrecio()/3);
           case 3:
               return (cantidadDeProductos * super.getPrecio()/2);
       }
    return 0;
    }
}
