public class RetiroEfectivo implements Transaccion{

    @Override
    public void transaccionOk(){
        System.out.println("El retiro de efectivo se realizó correctamente.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El retiro de efectivo no se pudo completar.");
    }
}
