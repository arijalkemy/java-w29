package com.meli.usuarios;

import com.meli.transacciones.ConsultaSaldo;
import com.meli.transacciones.RetiroEfectivo;

public class Cobrador {
    RetiroEfectivo retiroEfectivo;
    ConsultaSaldo consultaSaldo;

    public Cobrador() {
        this.retiroEfectivo = new RetiroEfectivo();
        this.consultaSaldo = new ConsultaSaldo();
    }


}
