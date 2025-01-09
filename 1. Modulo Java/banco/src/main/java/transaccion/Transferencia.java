package transaccion;

public class Transferencia implements Transaccion{
    @Override
    public void transaccionOK() {
        System.out.println("transferencia OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("transferencia no ok");
    }
}
