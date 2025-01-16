public class NoPerecedero extends Producto {
    String tipo;

    // Constructors
    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    // Methods
    @Override
    public String toString() {
        return super.toString() + " Tipo: " + tipo + ".";
    }
    // Getters
    public String getTipo() {
        return tipo;
    }

    // Setters
    public void setDiasPorCaducar(String tipo) {
        this.tipo = tipo;
    }

}
