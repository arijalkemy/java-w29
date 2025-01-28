package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
                // Creamos instancias de las transacciones
        Transacciones.Deposito deposito = new Transacciones.Deposito();
        Transacciones.Transferencia transferencia = new Transacciones.Transferencia();
        Transacciones.RetiroEfectivo retiro = new Transacciones.RetiroEfectivo();
        Transacciones.ConsultaSaldo consulta = new Transacciones.ConsultaSaldo();
        Transacciones.PagoServicios pago = new Transacciones.PagoServicios();

                // Creamos instancias de los clientes
        Clientes.Ejecutivo ejecutivo = new Clientes.Ejecutivo();
        Clientes.Basic basic = new Clientes.Basic();
        Clientes.Cobrador cobrador = new Clientes.Cobrador();
                // Ejemplo de uso
        ejecutivo.realizarDeposito(deposito);
        ejecutivo.realizarTransferencia(transferencia);

        basic.consultarSaldo(consulta);
        basic.pagarServicios(pago);
        basic.retirarEfectivo(retiro);

        cobrador.retirarEfectivo(retiro);
        cobrador.consultarSaldo(consulta);
    }
}
