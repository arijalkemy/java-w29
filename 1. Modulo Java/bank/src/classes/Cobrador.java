package classes;

import interfaces.ConsultaSaldo;
import interfaces.RetiroEfectivo;

public class Cobrador implements RetiroEfectivo, ConsultaSaldo {
    @Override
    public void consultarSaldo() {
        System.out.println("classes.Cobrador consultar saldo");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("classes.Cobrador retira efectivo");
    }

    @Override
    public void transaccionOk() {
        System.out.println("classes.Cobrador transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("classes.Cobrador transaccion no ok");
    }
}
