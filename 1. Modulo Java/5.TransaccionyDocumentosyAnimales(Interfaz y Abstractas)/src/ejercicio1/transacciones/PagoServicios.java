package ejercicio1.transacciones;

public class PagoServicios implements Transaccion {
    @Override
    public void ok() {
        System.out.println("Realizando pago servicios: ok");
    }

    @Override
    public void noOk() {
        System.out.println("Realizando pago servicios: no Ok");
    }
}
