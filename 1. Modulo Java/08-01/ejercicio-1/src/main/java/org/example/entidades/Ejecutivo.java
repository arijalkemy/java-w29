package org.example.entidades;

import org.example.interfaces.Deposito;
import org.example.interfaces.Transaccion;
import org.example.interfaces.Transferencia;

public class Ejecutivo extends Cliente implements Deposito, Transferencia, Transaccion {

    @Override
    public void depositar() {
        System.out.println("Depositando - Ejecutivo");
    }

    @Override
    public void transferir() {
        System.out.println("Transfiriendo - Ejecutivo");
    }
}
