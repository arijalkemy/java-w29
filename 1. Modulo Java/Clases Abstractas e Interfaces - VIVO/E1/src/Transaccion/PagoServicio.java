package Transaccion;

public class PagoServicio implements Transaccionable{
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicio existoso");
    }

    @Override
    public void transaccionError() {
        System.out.println("Error al intentar pago de servicio");
    }
}
