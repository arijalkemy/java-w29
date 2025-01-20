package Ex1.Clases;

import Ex1.Transactions.ConsultaSaldo;
import Ex1.Transactions.RetiroEfec;

public class Cobrador implements RetiroEfec, ConsultaSaldo {
    @Override
    public void consultarSaldo() {
        System.out.println("Consultando Saldo....");
        System.out.println("...");
        System.out.println("Su saldo es de $ 500.230");

    }

    @Override
    public void retirarEfectivo(Double monto) {
        System.out.println("Intentando retirar: " + monto);

    }

    @Override
    public void transaccionOk() {

        System.out.println( "Operación realizada correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Hubo un problema realizar la operación...");
    }
}
