package transacciones;

public class PagoDeServicios extends Transaccion {
    @Override
    public void doTransaction() {
        System.out.println("realizando pago de servicio");
        super.estadoTransaccion();
    }
}
