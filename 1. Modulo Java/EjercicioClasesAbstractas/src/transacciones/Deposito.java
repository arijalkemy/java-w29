package transacciones;

public class Deposito extends Transaccion {
    @Override
    public void doTransaction() {
        System.out.println("realizando deposito");
        super.estadoTransaccion();
    }
}
