public class PagoServicio implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("El pago de servicios se realizó correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El pago de servicios no se pudo completar.");
    }
}
