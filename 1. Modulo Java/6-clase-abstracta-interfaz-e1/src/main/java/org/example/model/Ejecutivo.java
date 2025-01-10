package org.example.model;

import org.example.inteface.ConsultaDeSaldo;
import org.example.inteface.Deposito;
import org.example.inteface.RetiroDeEfectivo;
import org.example.inteface.Transferencia;

public class Ejecutivo extends Cliente implements Deposito, Transferencia {
    public Ejecutivo(String nombre, Integer dni, Double saldo) {
        super(nombre, dni, saldo);
    }

    @Override
    public void depositar(Double deposito) {
        super.setSaldo(super.getSaldo() + deposito);
        Deposito.super.transaccionOk();
    }

    @Override
    public void transferir(Double tranferencia) {
        if(super.getSaldo() - tranferencia >= 0){
            Transferencia.super.transaccionOk();
            super.setSaldo(super.getSaldo() - tranferencia);
        } else {
            Transferencia.super.transaccionNoOk("Saldo no suficiente");
        }
    }
}
