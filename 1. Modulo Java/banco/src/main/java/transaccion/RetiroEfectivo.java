package transaccion;

public class RetiroEfectivo implements Transaccion{

    @Override
    public void transaccionOK() {
        System.out.println("Retiro efectivo Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro efectivo No Ok");
    }
}
