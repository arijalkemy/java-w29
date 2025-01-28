package com.example.interfaces;

import com.example.clientes.Cliente;

public interface Deposito extends Transaccion {
    default void depositar(int monto) {
        Cliente cliente = (Cliente) this;
        cliente.setSaldo(cliente.getSaldo() + monto);
        transaccionOk();
    }
}
