public class PagoServicios implements Transaccion{

    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicio realizado exitosamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar el pago de servicios");
    }
}
