package com.interfaces;

public interface Transaccionable {
    public void transaccionOk();

    public void transaccionNoOk();

    public void realizarTransaccion(Cliente client);
}