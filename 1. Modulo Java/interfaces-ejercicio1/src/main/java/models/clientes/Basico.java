package models.clientes;

import models.transacciones.ConsultaSaldo;
import models.transacciones.PagoServicios;
import models.transacciones.RetiroEfectivo;
import models.transacciones.Transaccion;

public class Basico extends Cliente {

    public Basico(String nombre) {
        super(nombre);
    }

    public void consultarSaldo() {
        System.out.printf("Cliente Basico '%s' consultando saldo%n", this.getNombre());
        Transaccion consulta = new ConsultaSaldo();
        consulta.transaccionOk();
    }

    public void realizarRetiro() {
        System.out.printf("Cliente Basico '%s' realizando retiro%n", this.getNombre());
        Transaccion retiro = new RetiroEfectivo();
        retiro.transaccionOk();
    }

    public void realizarPago() {
        System.out.printf("Cliente Basico '%s' realizando pago%n", this.getNombre());
        Transaccion pago = new PagoServicios();
        pago.transaccionOk();
    }

}
