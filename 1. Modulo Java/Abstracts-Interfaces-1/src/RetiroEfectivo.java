public class RetiroEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
    System.out.println("Retiro efectivo realizado con exito");
    }

    @Override
    public void transaccionNoOk() {
    System.out.println("Retiro efectivo no realizado");
    }
}
