package org.example;

import clientes.Basico;
import clientes.Cliente;
import clientes.Cobradores;
import clientes.Ejecutivo;
import transaccion.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Crear objetos de las transacciones
        Transaccion deposito = new Deposito();
        Transaccion transferencia = new Transferencia();
        Transaccion retiro = new RetiroEfectivo();
        Transaccion consultaSaldo = new ConsultarSaldo();
        Transaccion pagoServicios = new PagoServicios();

        // Crear clientes
        Cliente ejecutivo = new Ejecutivo();
        Cliente basico = new Basico();
        Cliente cobrador = new Cobradores();

        // Ejecutivos pueden realizar Depósitos y Transferencias
        System.out.println("Ejecutivo:");
        ejecutivo.realizarTransaccion(deposito);
        ejecutivo.realizarTransaccion(transferencia);
        ejecutivo.realizarTransaccion(retiro);
        ejecutivo.realizarTransaccion(consultaSaldo);
        ejecutivo.realizarTransaccion(pagoServicios);

        // Cliente Básico puede realizar Consultas de Saldo, Pagos y Retiros
        System.out.println("\nCliente Básico:");
        basico.realizarTransaccion(consultaSaldo);
        basico.realizarTransaccion(pagoServicios);
        basico.realizarTransaccion(retiro);
        basico.realizarTransaccion(deposito);
        basico.realizarTransaccion(transferencia);

        // Cobrador puede realizar Retiros y Consultas de Saldo
        System.out.println("\nCobrador:");
        cobrador.realizarTransaccion(consultaSaldo);
        cobrador.realizarTransaccion(retiro);
        cobrador.realizarTransaccion(deposito);
        cobrador.realizarTransaccion(transferencia);
        cobrador.realizarTransaccion(pagoServicios);

    }
}