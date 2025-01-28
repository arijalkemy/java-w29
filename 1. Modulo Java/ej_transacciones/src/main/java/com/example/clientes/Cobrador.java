package com.example.clientes;

import com.example.interfaces.ConsultaSaldo;
import com.example.interfaces.RetiroEfectivo;

public class Cobrador extends Cliente implements RetiroEfectivo, ConsultaSaldo {
    public Cobrador(int saldo) {
        super(saldo);
    }
}
