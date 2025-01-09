package clases;

import ejercicio1.interfaces.ConsultaSaldo;
import ejercicio1.interfaces.RetiroEfectivo;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo {

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo");
    }

    @Override
    public void retirarEfectivo(Double monto) {
        System.out.println("Retirando efectivo");
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
