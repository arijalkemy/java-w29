package org.example.entidades;

import org.example.interfaces.ConsultaSaldo;
import org.example.interfaces.PagoServicio;
import org.example.interfaces.RetiroEfectivo;

public class Basic extends Cliente implements ConsultaSaldo, PagoServicio, RetiroEfectivo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo - Basic");
    }

    @Override
    public void pagarServicio() {
        System.out.println("Pagando servicio - Basic");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retirando efectivo - Basic");
    }
}
