package org.example.poo.part2;

public class NoPerecedero extends Producto{

    /*tener un atributo llamado tipo, el mismo va a ser un String,
    crear setters, getters, constructor y método toString();
    en esta clase el método calcular() va a hacer exactamente lo mismo que en la clase Producto.*/

    private String tipo;

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
    public String toString() {
        return "NoPerecedero {" +
                " nombre='" + getNombre() + '\'' +
                ", precio=" + getPrecio() +
                " tipo='" + tipo + '\'' +
                " }";
    }

    //no hace falta agregar xq hace lo mismo que en la clase Producto
    @Override
    public double calcular(int cantidadDeProductos) {
        return super.calcular(cantidadDeProductos);
    }
}
