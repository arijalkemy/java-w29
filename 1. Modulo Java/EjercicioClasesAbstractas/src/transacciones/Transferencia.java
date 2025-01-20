package transacciones;

public class Transferencia extends Transaccion{
    @Override
    public void doTransaction() {
        System.out.println("realizando operacion de transferencia");
        super.estadoTransaccion();
    }
}
