package Ejercicio2;

public class NoPrecedero extends Producto{

    private String tipo;

    public NoPrecedero(String nombre, double precio,String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
