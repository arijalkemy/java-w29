package clases;

import ejercicio1.interfaces.ConsultaSaldo;
import ejercicio1.interfaces.PagoServicio;
import ejercicio1.interfaces.RetiroEfectivo;

public class Basic implements ConsultaSaldo, PagoServicio, RetiroEfectivo {

    @Override
    public void consultarSaldo() {
        System.out.println("Consultar Saldo");
    }

    @Override
    public void pagarServicio(String servicio) {
        System.out.println("Pagar Servicio");
    }

    @Override
    public void retirarEfectivo(Double monto) {
        System.out.println("Retirar Efectivo");
    }

    @Override
    public void transaccionOk(String transaccion) {
        System.out.println("Transaccion Ok");
    }

    @Override
    public void transaccionNoOk(String transaccion) {
        System.out.println("Transaccion No Ok");
    }
}
