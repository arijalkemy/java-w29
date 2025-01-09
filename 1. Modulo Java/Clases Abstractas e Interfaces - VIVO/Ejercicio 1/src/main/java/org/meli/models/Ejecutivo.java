package org.meli.models;

import org.meli.interfaces.Transaccion;

public class Ejecutivo extends Cliente{
    public Ejecutivo(String nombre) {
        super(nombre);
    }

    @Override
    public void realizarTransaccion(Transaccion transaccion, boolean exito) {
        System.out.println("Ejecutivo " + nombre + " está realizando una transacción.");
        if (exito) {
            transaccion.transaccionOk();
        } else {
            transaccion.transaccionNoOk();
        }
    }
}
