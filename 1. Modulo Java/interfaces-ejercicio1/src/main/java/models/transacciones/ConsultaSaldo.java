package models.transacciones;

public class ConsultaSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Se ha realizado la consulta de saldo");
    }

    @Override
    public void transaccionNotOk() {
        System.out.println("Error al consultar saldo");
    }
}
