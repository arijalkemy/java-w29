package org.example;


public class Cobradores implements RetiroDeEfectivo, ConsultaDeSaldo{
    @Override
    public void consultarSaldo() {
        System.out.println("Cobrador consulta saldo");
    }

    @Override
    public void retirar() {
        System.out.println("Cobrador retira");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Cobrador transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Cobrador transaccion no ok");
    }
}


