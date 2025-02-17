package com.example.demo.abstractClass.ej_1;

public class Basic {
    private RetiroEfectivo retiroEfectivo = new RetiroEfectivo();
    private ConsultaSaldo consultaSaldo = new ConsultaSaldo();
    private PagoServicios pagoServicios = new PagoServicios();

    public void realizarRetiro() {
        retiroEfectivo.transaccionOk();
    }

    public void consultarSaldo() {
        consultaSaldo.transaccionOk();
    }

    public void pagarServicios() {
        pagoServicios.transaccionOk();
    }
}
