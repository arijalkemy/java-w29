package org.meli.models;

import org.meli.interfaces.Transaccion;

public class Basic extends Cliente{
    public Basic(String nombre) {
        super(nombre);
    }

    @Override
    public void realizarTransaccion(Transaccion transaccion, boolean exito) {
        System.out.println("Cliente Basic " + nombre + " está realizando una transacción.");
        if (exito) {
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
