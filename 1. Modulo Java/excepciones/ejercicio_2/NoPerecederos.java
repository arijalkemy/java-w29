package ejercicio_2;

public class NoPerecederos extends Producto {
    public String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public NoPerecederos(String nombre, Double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    @Override
    public Double Calcular(int CantidadDeProductos) {
        return precio * (CantidadDeProductos);
    }
}
