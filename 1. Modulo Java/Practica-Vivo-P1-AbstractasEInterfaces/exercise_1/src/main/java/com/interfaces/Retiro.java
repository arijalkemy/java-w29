package com.interfaces;

public class Retiro implements Transaccionable {

    public Retiro() {

    }

    @Override
    public void transaccionOk() {
        System.out.println("Retiro realizado");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro no realizado, fallo en la transacción.");
    }

    @Override
    public void realizarTransaccion(Cliente client) {

        System.out.println("Realizando retiro ...");

        String type = client.getClass().getName().replaceAll("com.interfaces.", "");

        if (type.equals("Basico") || type.equals("Cobrador")) {
            transaccionOk();
        } else {
            transaccionNoOk();
        }
    }

}
