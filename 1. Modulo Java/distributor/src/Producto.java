public class Producto {
    private String nombre;
    private double precio;

    // Constructors
    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    // Methods
    @Override
    public String toString() {
        return "Nombre: " + nombre + ". Precio: " + precio + ".";
    }

    public double calcular(int cantidadDeProductos) {
        return cantidadDeProductos * precio;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
