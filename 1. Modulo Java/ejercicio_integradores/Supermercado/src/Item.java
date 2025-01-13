public class Item {
    Double codigo;
    String nombre;
    Double cantidad;
    Double costo;

    public Item(Double codigo, String nombre, Double cantidad, Double costo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", costo=" + costo +
                '}';
    }
}
