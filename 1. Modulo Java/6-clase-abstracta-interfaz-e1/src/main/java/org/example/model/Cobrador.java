package org.example.model;

import org.example.inteface.ConsultaDeSaldo;
import org.example.inteface.RetiroDeEfectivo;

public class Cobrador extends Cliente implements RetiroDeEfectivo, ConsultaDeSaldo {
    public Cobrador(String nombre, Integer dni, Double saldo) {
        super(nombre, dni, saldo);
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Saldo: " + super.getSaldo());
        ConsultaDeSaldo.super.transaccionOk();
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
