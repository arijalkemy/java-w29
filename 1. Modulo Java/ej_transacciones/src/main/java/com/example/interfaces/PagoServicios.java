package com.example.interfaces;

import com.example.clientes.Cliente;

public interface PagoServicios extends Transaccion {

    default void pagarServicio(int monto) {
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
