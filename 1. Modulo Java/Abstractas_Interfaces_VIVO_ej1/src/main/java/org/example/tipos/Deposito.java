package org.example.tipos;

import org.example.clientes.Transaccion;

public class Deposito implements Transaccion {
    @Override
    public void transaccionCorrecta() {
        System.out.println("Deposito exitoso.");
    }

    @Override
    public void transaccionIncorrecta() {
        System.out.println("Deposito no exitoso.");
    }
}
