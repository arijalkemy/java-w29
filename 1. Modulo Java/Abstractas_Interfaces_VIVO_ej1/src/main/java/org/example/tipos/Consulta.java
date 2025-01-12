package org.example.tipos;

import org.example.clientes.Transaccion;

public class Consulta implements Transaccion {

    @Override
    public void transaccionCorrecta() {
        System.out.println("Consulta de saldo exitosa.");
    }

    @Override
    public void transaccionIncorrecta() {
        System.out.println("Consulta de saldo no exitosa.");
    }
}
