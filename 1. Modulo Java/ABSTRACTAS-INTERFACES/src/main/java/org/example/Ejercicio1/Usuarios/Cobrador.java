package org.example.Ejercicio1.Usuarios;

import org.example.Ejercicio1.transacciones.ConsultaSaldo;
import org.example.Ejercicio1.transacciones.RetiroEfectivo;

public class Cobrador {
    RetiroEfectivo retiroEfectivo;
    ConsultaSaldo consultaSaldo;

    public Cobrador() {
        this.retiroEfectivo = new RetiroEfectivo();
        this.consultaSaldo = new ConsultaSaldo();
    }

}
