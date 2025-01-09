package com.thiagoschreck.local.banco.clientes;

import com.thiagoschreck.local.banco.transacciones.Deposito;
import com.thiagoschreck.local.banco.transacciones.Transferencia;

public class Ejecutivo extends Cliente {
    @Override
    public void depositar() {
        new Deposito().transaccionOk();
    }

    @Override
    public void transferir() {
        new Transferencia().transaccionOk();
    }
}
