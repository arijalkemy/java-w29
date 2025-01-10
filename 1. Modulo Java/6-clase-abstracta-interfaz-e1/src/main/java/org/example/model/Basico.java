package org.example.model;

import org.example.inteface.ConsultaDeSaldo;
import org.example.inteface.PagoDeServicios;
import org.example.inteface.RetiroDeEfectivo;

public class Basico extends Cliente implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo {
    public Basico(String nombre, Integer dni, Double saldo) {
        super(nombre, dni, saldo);
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo: " + super.getSaldo());
    }

    @Override
    public void pagarServicios(Double pagar) {
        if(super.getSaldo()-pagar >= 0){
            PagoDeServicios.super.transaccionOk();
            super.setSaldo(super.getSaldo() - pagar);
        } else {
            RetiroDeEfectivo.super.transaccionNoOk("Saldo no suficiente");
        }
    }

    @Override
    public void retirarEfectivo(Double retiro) {
        if(super.getSaldo()-retiro >= 0){
            RetiroDeEfectivo.super.transaccionOk();
            super.setSaldo(super.getSaldo() - retiro);
        } else {
            RetiroDeEfectivo.super.transaccionNoOk("Saldo no suficiente");
        }
    }
}
