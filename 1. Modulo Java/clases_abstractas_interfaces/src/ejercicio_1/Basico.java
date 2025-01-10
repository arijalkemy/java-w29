package ejercicio_1;

import java.util.Random;

public class Basico implements ConsultarSaldo, PagoServicio, RetiroEfectivo{

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
    public void pagarServicio(String servicio, Double monto) {
        System.out.println("Pagando servicio " + servicio);
        transaccionOk();
    }

    @Override
    public void realizarRetiroEfectivo(Double monto) {
        System.out.println("Realizando retiro efectivo");
        transaccionOk();
    }

}
