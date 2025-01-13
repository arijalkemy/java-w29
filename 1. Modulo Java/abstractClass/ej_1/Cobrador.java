package com.example.demo.abstractClass.ej_1;

public class Cobrador {
    private RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
    private ConsultaSaldo consultaSaldo = new ConsultaSaldo();

    public void realizarRetiro() {
        retiroEfectivo.transaccionOk();
    }

    public void consultarSaldo() {
        consultaSaldo.transaccionOk();
    }
}
