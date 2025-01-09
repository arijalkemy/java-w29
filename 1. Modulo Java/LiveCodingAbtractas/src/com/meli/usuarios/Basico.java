package com.meli.usuarios;

import com.meli.transacciones.ConsultaSaldo;
import com.meli.transacciones.PagoServicios;
import com.meli.transacciones.RetiroEfectivo;

public class Basico {
    PagoServicios pagoServicios;
    ConsultaSaldo consultaSaldo;
    RetiroEfectivo retiroEfectivo;

    public Basico() {
        this.pagoServicios = new PagoServicios();
        this.consultaSaldo = new ConsultaSaldo();
        this.retiroEfectivo = new RetiroEfectivo();
    }
}
