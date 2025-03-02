package Transaccion;

public class Deposito implements Transaccionable{
    @Override
    public void transaccionOk() {
        System.out.println("Depósito realizado con éxito");
    }

    @Override
    public void transaccionError() {
        System.out.println("Error al realizar el deposito");
    }
}
