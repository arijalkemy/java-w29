public class RetiroEfectivo implements Transaccion{


    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo realizado correctamente");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar el retiro");
    }
}
