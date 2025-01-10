package ejercicio_1;

public class Cobrador implements RetiroEfectivo, ConsultarSaldo{

    @Override
    public void transaccionOk() {
        System.out.println("Transacción exitosa");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transacción fallida");
    }


    @Override
    public void consultarSaldo() {
        System.out.println("Consultando saldo...");
        transaccionOk();
    }

    @Override
    public void realizarRetiroEfectivo(Double monto) {
        System.out.println("Realizando retiro efectivo");
        transaccionOk();
    }


}
