package com.thiagoschreck.local.banco.clientes;

import com.thiagoschreck.local.banco.transacciones.ConsultaDeSaldo;
import com.thiagoschreck.local.banco.transacciones.PagoDeServicios;
import com.thiagoschreck.local.banco.transacciones.RetiroDeEfectivo;

public class Basic extends Cliente {
    @Override
    public void consultarSaldo() {
        new ConsultaDeSaldo().transaccionOk();
    }

    @Override
    public void pagarServicios() {
        new PagoDeServicios().transaccionOk();
    }

    @Override
    public void retirarEfectivo() {
        new RetiroDeEfectivo().transaccionOk();
    }
}
