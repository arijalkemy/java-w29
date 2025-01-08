package models.transacciones;

public class RetiroEfectivo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro realizado");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Error al realizar retiro");
    }
}
