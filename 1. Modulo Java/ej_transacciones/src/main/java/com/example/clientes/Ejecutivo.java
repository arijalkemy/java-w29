package com.example.clientes;

import com.example.interfaces.Deposito;
import com.example.interfaces.Transferencia;

public class Ejecutivo extends Cliente implements Deposito, Transferencia {
    public Ejecutivo(int saldo) {
        super(saldo);
    }
}
