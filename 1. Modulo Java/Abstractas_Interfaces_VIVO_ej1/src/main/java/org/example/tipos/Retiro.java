package org.example.tipos;

import org.example.clientes.Transaccion;

public class Retiro implements Transaccion {
    @Override
    public void transaccionCorrecta() {
        System.out.println("Retiro de manera exitosa.");
    }

    @Override
    public void transaccionIncorrecta() {
        System.out.println("Retiro de manera no exitosa.");
    }
}
