package org.meli.models;

public class Perecedero extends Producto {
    private Integer diasPorCaducar;

    public Perecedero(String nombre, Double precio, Integer diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public Double calcular(Integer diasPorCaducar){
        Double precio = this.getPrecio();
        if(diasPorCaducar==1)
            return precio*0.25;
        else if(diasPorCaducar==2)
            return precio*0.33;
        else if(diasPorCaducar==3)
            return precio*0.5;
        else
            return precio;
    }
}

