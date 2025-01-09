public class Transferencia implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("La transferencia se realizó correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transferencia no se pudo completar.");
    }
}
