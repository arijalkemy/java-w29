package com.thiagoschreck.local.banco.clientes;

import com.thiagoschreck.local.banco.transacciones.ConsultaDeSaldo;
import com.thiagoschreck.local.banco.transacciones.Deposito;
import com.thiagoschreck.local.banco.transacciones.PagoDeServicios;
import com.thiagoschreck.local.banco.transacciones.RetiroDeEfectivo;
import com.thiagoschreck.local.banco.transacciones.Transferencia;

public abstract class Cliente {
    public void depositar() {
        new Deposito().transaccionNoOk();
    }

    public void transferir() {
        new Transferencia().transaccionNoOk();
    }

    public void consultarSaldo() {
        new ConsultaDeSaldo().transaccionNoOk();
    }

    public void pagarServicios() {
        new PagoDeServicios().transaccionNoOk();
    }

    public void retirarEfectivo() {
        new RetiroDeEfectivo().transaccionNoOk();
    }
}
