package org.example.poo.part2;

import org.example.poo.part2.Interface.Deposito;
import org.example.poo.part2.Interface.Transferencia;

public class Ejecutivo implements Transferencia, Deposito {

    @Override
    public void hacerTransferencia() {
        System.out.println("Haciendo transferencia...");
    }

    @Override
    public void hacerDeposito() {
        System.out.println("Haciendo depósito...");
    }

    @Override
    public void transaccionOk(String tipoTransacc) {
        System.out.println( tipoTransacc +  " realizada correctamente");
    }

    @Override
    public void transaccionNoOk(String tipoTransacc) {
        System.out.println("La transacción " + tipoTransacc +  " no se pudo concluir");
    }
}
