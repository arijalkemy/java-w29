package Transaccion;

public class RetiroEfectivo implements Transaccionable{
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo exitoso");
    }

    @Override
    public void transaccionError() {
        System.out.println("Error al retirar el efectivo");
    }
}
