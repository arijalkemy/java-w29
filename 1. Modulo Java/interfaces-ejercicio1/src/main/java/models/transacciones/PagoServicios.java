package models.transacciones;

public class PagoServicios implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios realizado");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Error al realizar el pago de servicios");
    }
}
