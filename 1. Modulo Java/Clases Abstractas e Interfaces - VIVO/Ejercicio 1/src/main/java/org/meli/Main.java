package org.meli;

import org.meli.interfaces.Transaccion;
import org.meli.models.Basic;
import org.meli.models.Cliente;
import org.meli.models.Cobrador;
import org.meli.models.Ejecutivo;
import org.meli.services.*;

public class Main {
    public static void main(String[] args) {
        Transaccion deposito = new Deposito();
        Transaccion transferencia = new Transferencia();
        Transaccion retiroEfectivo = new RetiroEfectivo();
        Transaccion consultaSaldo = new ConsultaSaldo();
        Transaccion pagoServicios = new PagoServicios();

        Cliente ejecutivo = new Ejecutivo("Carlos");
        Cliente basic = new Basic("Ana");
        Cliente cobrador = new Cobrador("Luis");

        ejecutivo.realizarTransaccion(deposito, true);
        ejecutivo.realizarTransaccion(transferencia, false);

        basic.realizarTransaccion(consultaSaldo, true);
        basic.realizarTransaccion(pagoServicios, true);
        basic.realizarTransaccion(retiroEfectivo, false);

        cobrador.realizarTransaccion(consultaSaldo, true);
        cobrador.realizarTransaccion(retiroEfectivo, true);
    }
}