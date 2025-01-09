package com.example.interfaces;

import com.example.clientes.Cliente;

public interface ConsultaSaldo extends Transaccion {

    default void consultarSaldo() {
        Cliente cliente = (Cliente) this;
        System.out.println("Saldo disponible: " + cliente.getSaldo());
    }

}