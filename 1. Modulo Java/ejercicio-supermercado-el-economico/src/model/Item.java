package model;

public class Item {
    private long codigo;
    private String nombre;
    private int cantidad;
    private double costoUnitario;

    public Item(long codigo, int cantidad, String nombre, double costoUnitario) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.costoUnitario = costoUnitario;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }
}
