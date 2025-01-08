package models.clientes;

import models.transacciones.ConsultaSaldo;
import models.transacciones.RetiroEfectivo;
import models.transacciones.Transaccion;

public class Cobrador extends Cliente{

    public Cobrador(String nombre) {
        super(nombre);
    }

    public void consultarSaldo() {
        System.out.printf("Cliente Cobrador '%s' consultando saldo%n", this.getNombre());
        Transaccion consulta = new ConsultaSaldo();
        consulta.transaccionOk();
    }

    public void realizarRetiro() {
        System.out.printf("Cliente Cobrador '%s' realizando retiro%n", this.getNombre());
        Transaccion retiro = new RetiroEfectivo();
        retiro.transaccionOk();
    }
}
