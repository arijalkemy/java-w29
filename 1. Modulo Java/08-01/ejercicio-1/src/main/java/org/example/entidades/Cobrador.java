package org.example.entidades;

import org.example.interfaces.ConsultaSaldo;
import org.example.interfaces.RetiroEfectivo;

public class Cobrador extends Cliente implements RetiroEfectivo, ConsultaSaldo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo - Cobrador");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo - Cobrador");
    }
}
