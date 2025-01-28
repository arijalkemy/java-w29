package org.example;

public class NoPerecedero extends Producto {
    private String tipo;

    // Constructor
    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        return super.calcular(cantidadDeProductos);
    }

    @Override
    public String toString() {
        return super.toString() + ", NoPerecedero [tipo=" + tipo + "]";
    }
}


