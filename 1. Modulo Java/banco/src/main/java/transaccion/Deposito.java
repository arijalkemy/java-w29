package transaccion;

public class Deposito implements Transaccion{

    @Override
    public void transaccionOK() {
        System.out.println("Deposito OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Deposito no ok");
    }
}
