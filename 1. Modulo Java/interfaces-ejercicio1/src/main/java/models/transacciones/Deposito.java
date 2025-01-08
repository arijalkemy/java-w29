package models.transacciones;

public class Deposito implements Transaccion {

    private int cantidad;

    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado correctamente");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Error al hacer el deposito");
    }
}
