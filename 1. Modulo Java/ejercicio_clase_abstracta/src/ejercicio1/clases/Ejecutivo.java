package ejercicio1.clases;

import ejercicio1.interfaces.Deposito;
import ejercicio1.interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {

    @Override
    public void depositar() {
        System.out.println("Depositando");
    }

    @Override
    public void transferir() {
        System.out.println("Transferir");
    }

    @Override
    public void transaccionOk(String transaccion) {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk(String transaccion) {
        System.out.println("Transaccion no ok");
    }
}
