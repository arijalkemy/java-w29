package classes;

import interfaces.ConsultaSaldo;
import interfaces.PagoServicios;
import interfaces.RetiroEfectivo;

public class Basico implements ConsultaSaldo, PagoServicios, RetiroEfectivo {
    @Override
    public void transaccionOk() {
        System.out.println("classes.Basico transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("classes.Basico transaccion no ok");
    }

    @Override
    public void consultarSaldo() {
        System.out.println("classes.Basico consultar saldo");
    }

    @Override
    public void pagarServicios() {
        System.out.println("classes.Basico paga servicios");
    }
    @Override
    public void retirarEfectivo() {
        System.out.println("classes.Basico retira efectivo");
    }
}
