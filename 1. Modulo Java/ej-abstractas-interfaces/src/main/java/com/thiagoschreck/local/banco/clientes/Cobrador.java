package com.thiagoschreck.local.banco.clientes;

import com.thiagoschreck.local.banco.transacciones.ConsultaDeSaldo;
import com.thiagoschreck.local.banco.transacciones.RetiroDeEfectivo;

public class Cobrador extends Cliente {
    @Override
    public void retirarEfectivo() {
        new RetiroDeEfectivo().transaccionOk();
    }

    @Override
    public void consultarSaldo() {
        new ConsultaDeSaldo().transaccionOk();
    }
}
