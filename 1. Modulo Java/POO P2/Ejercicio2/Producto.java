package Ejercicio2;

public class Producto {
    private String name;
    private double price;
    
    public Producto(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Producto [name=" + name + ", price=" + price + "]";
    }

    public double calcular(int cantidadDeProductos){
        double result = this.price * cantidadDeProductos;
        return result;
    }
    
}
