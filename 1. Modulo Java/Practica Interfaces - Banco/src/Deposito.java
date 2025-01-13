public class Deposito implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("La transacción de depósito se realizó correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transacción de depósito no se pudo completar.");
    }
}
