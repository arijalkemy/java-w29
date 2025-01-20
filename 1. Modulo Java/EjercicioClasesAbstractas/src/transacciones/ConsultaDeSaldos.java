package transacciones;

public class ConsultaDeSaldos extends Transaccion {
    @Override
    public void doTransaction() {
        System.out.println("Consultando saldo");
        super.estadoTransaccion();
    }
}
