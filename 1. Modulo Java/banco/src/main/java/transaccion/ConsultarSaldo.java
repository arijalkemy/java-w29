package transaccion;

public class ConsultarSaldo implements Transaccion {

    @Override
    public void transaccionOK() {
        System.out.println("Consultar saldo OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Consultar saldo NOK");
    }
}
