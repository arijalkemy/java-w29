package org.example.tipos;

import org.example.clientes.Transaccion;

public class Transferencia implements Transaccion {

    @Override
    public void transaccionCorrecta() {
        System.out.println("Transferencia exitosa.");
    }

    @Override
    public void transaccionIncorrecta() {
        System.out.println("Transferencia no exitosa.");
    }
}
