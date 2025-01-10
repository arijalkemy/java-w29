package ejercicio_2;

public class NoPerecedero extends Producto {
    private String tipo;

    // Constructor
    public NoPerecedero(String nombre, Double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    // Getters y Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + ", NoPerecedero [tipo=" + tipo + "]";
    }
}



