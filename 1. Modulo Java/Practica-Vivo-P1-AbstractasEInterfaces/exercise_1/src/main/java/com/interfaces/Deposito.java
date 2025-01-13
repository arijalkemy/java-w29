package com.interfaces;

public class Deposito implements Transaccionable {

    public Deposito() {

    }

    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito no realizado, fallo en la transacción.");
    }

    @Override
    public void realizarTransaccion(Cliente client) {

        System.out.println("Realizando deposito ...");

        String type = client.getClass().getName().replaceAll("com.interfaces.", "");

        if (type.equals("Ejecutivo")) {
            transaccionOk();
        } else {
            transaccionNoOk();
        }
    }

}
