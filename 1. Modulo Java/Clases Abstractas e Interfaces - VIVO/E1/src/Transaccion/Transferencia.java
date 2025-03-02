package Transaccion;

public class Transferencia implements Transaccionable{
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada con exito");
    }

    @Override
    public void transaccionError() {
        System.out.println("Error al realizar transferencia");
    }
}
