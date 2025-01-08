package org.ejercicio1;

public class Cobrador extends Cliente implements RetiroEfectivo, ConsultaSaldo{

    @Override
    public void hacerConsultaSaldo() {
        System.out.println("Saldo del cobrador: " + getSaldoTotal());
    }

    @Override
    public void hacerRetiroEfectivo() {
        System.out.println("Haciendo retiro efectivo");
        transaccionOk();
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no ok");
    }
}
