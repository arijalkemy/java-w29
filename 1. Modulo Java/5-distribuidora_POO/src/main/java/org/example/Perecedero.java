package org.example;

public class Perecedero extends Producto {
    //2- Crear la clase Perecedero, que va a tener un atributo llamado diasPorCaducar de tipo int,
    //al igual que para el producto, definir setters, getters, constructor que reciba todos los
    //atributos por parámetro y el método toString(). Esta clase debe heredar de Producto y
    // sobreescribir el método calcular(), el cual tiene que hacer lo mismo que la clase Producto
    //  (multiplicar el precio por la cantidad de productos) y adicionalmente, reducir el precio
    //  según los diasPorCaducar:
    //Si le resta un día (1) para caducar, se reducirá 4 veces el precio final.
    //Si le restan dos días (2) para caducar, se reducirá 3 veces el precio final.
    //Si le restan 3 días (3) para caducar, se reducirá la mitad de su precio final.

    private Integer diasPorcaducar;

    public Integer getDiasPorcaducar() {
        return diasPorcaducar;
    }

    public void setDiasPorcaducar(Integer diasPorcaducar) {
        this.diasPorcaducar = diasPorcaducar;
    }

    public Perecedero(String nombre, double precio, Integer diasPorcaducar) {
        super(nombre, precio);
        this.diasPorcaducar = diasPorcaducar;
    }

    @Override
    public String toString() {
        return super.toString() + ", Días para caducar: " +diasPorcaducar;
    }

    @Override
    public double calcular(int cantProductos) {
        double precio = super.calcular(cantProductos);
        double precioFinal=precio;
        if (diasPorcaducar==1){
            precioFinal=precio/4;
        } else if (diasPorcaducar==2) {
            precioFinal=precio/3;
        } else if (diasPorcaducar==3) {
            precioFinal=precio/2;
        }

        return precioFinal;

    }
}
