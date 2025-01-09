package transaccion;

public class PagoServicios implements Transaccion {
    @Override
    public void transaccionOK() {
        System.out.println("Pago servicios OK");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago servicios no OK");
    }
}
