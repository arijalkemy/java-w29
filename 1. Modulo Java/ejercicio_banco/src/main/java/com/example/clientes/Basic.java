package com.example.clientes;

import com.example.interfaces.ConsultaSaldo;
import com.example.interfaces.PagoServicios;
import com.example.interfaces.RetiroEfectivo;

public class Basic extends Cliente implements ConsultaSaldo, PagoServicios, RetiroEfectivo {
    public Basic(int saldo) {
        super(saldo);
    }
}
