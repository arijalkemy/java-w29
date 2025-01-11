package org.example.Ejercicio1.Usuarios;

import org.example.Ejercicio1.transacciones.ConsultaSaldo;
import org.example.Ejercicio1.transacciones.PagosServicios;
import org.example.Ejercicio1.transacciones.RetiroEfectivo;

public class Basico {

    PagosServicios pagoServicios;
    ConsultaSaldo consultaSaldo;
    RetiroEfectivo retiroEfectivo;

    public Basico() {
        this.pagoServicios = new PagosServicios();
        this.consultaSaldo = new ConsultaSaldo();
        this.retiroEfectivo = new RetiroEfectivo();
    }
}

