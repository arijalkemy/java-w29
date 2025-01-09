package ej1;

public class Ejecutivo implements Deposito, Transferencia{
    @Override
    public void depositar() {
        System.out.println("ej1.Ejecutivo depositado");
    }

    @Override
    public void transferir() {
        System.out.println("ej1.Ejecutivo transferido");
    }

    @Override
    public void transaccionOk() {
        System.out.println("ej1.Ejecutivo transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("ej1.Ejecutivo transaccion no ok");
    }
}
