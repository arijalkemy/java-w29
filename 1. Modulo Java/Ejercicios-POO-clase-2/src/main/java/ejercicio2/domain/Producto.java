package ejercicio2.domain;

public class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String toString() {
        return "Nombre: " + nombre + "\nPrecio: " + precio;
    }

    public int calcular(int cantidadDeProductos) {
        return (int) (precio * cantidadDeProductos);
    }
}





