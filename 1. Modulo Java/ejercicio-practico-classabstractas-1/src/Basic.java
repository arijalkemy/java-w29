public class Basic implements ConsultaSaldo, PagoServicios, RetiroDeEfectivo{

    public Basic(){
    }

    @Override
    public void consultarSaldo(){
        System.out.println("Su saldo es: ");
    }

    @Override
    public void realizarPago(double valor){
        System.out.println("Usted pago: "+valor);
    }

    @Override
    public void retirarEfectivo(double valor){
        System.out.println("Su retiro es de: "+valor);
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion exitosa");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion fallida");
    }
}
