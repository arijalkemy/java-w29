package models.transacciones;

public class Transferencia implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada correctamente");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Error al realizar la transferencia");
    }
}
