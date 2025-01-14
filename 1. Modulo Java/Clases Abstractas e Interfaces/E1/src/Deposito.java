public class Deposito implements Transaccion {


    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado exitosamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar el deposito");
    }
}
