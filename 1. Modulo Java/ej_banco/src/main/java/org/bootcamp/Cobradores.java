package org.bootcamp;

public class Cobradores implements RetiroEfectivo, ConsultaSaldo{
    @Override
    public void consultarSaldo() {
        System.out.println("Consultar saldo Cobrador");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Retirar efectivo Cobrador");
    }

    @Override
    public void transaccionOk(String transaccion) {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk(String transaccion) {
        System.out.println("Transaccion no ok");
    }
}
