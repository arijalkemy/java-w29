package transacciones;

public class RetiroDeDinero extends Transaccion{
    @Override
    public void doTransaction() {
        System.out.println("realizando operacion de retiro de dinero");
        super.estadoTransaccion();
    }
}
