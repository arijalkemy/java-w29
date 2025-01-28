package com.example.interfaces;

import com.example.clientes.Cliente;

public interface Transferencia extends Transaccion {
    default void realizarTransferencia(int monto) {
        Cliente cliente = (Cliente) this;
        int montoFinal = cliente.getSaldo() - monto;
        if (montoFinal >= 0) {
            transaccionOk();
            cliente.setSaldo(montoFinal);
        } else {
            transaccionNoOk("Monto insuficiente");
        }
    }
}
