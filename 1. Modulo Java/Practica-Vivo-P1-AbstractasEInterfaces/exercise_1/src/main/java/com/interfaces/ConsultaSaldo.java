package com.interfaces;

public class ConsultaSaldo implements Transaccionable {

    public ConsultaSaldo() {

    }

    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo realizada");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consulta de saldo no realizada, fallo en la transacción.");
    }

    @Override
    public void realizarTransaccion(Cliente client) {

        System.out.println("Realizando Consulta de saldo ...");

        String type = client.getClass().getName().replaceAll("com.interfaces.", "");

        if (type.equals("Basico") || type.equals("Cobrador")) {
            transaccionOk();
        } else {
            transaccionNoOk();
        }
    }

}
