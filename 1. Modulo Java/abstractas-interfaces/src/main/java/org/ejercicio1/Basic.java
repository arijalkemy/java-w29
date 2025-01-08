package org.ejercicio1;

public class Basic extends Cliente implements ConsultaSaldo, PagoServicio, RetiroEfectivo{
    @Override
    public void hacerConsultaSaldo() {
        System.out.println("Saldo del basic: " + getSaldoTotal());
    }

    @Override
    public void hacerPagoServicio() {
        System.out.println("Haciendo pago servicio");
    }

    @Override
    public void hacerRetiroEfectivo() {
        System.out.println("Haciendo retiro efectivo");
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
