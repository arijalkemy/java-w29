package com.example.clientes;

public class Cliente {

    private int saldo;

    public Cliente(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int monto) {
        this.saldo = monto;
    }

}
