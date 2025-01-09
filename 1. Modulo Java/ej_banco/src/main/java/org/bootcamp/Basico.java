package org.bootcamp;

public class Basico implements ConsultaSaldo, PagoServicio, RetiroEfectivo{
    @Override
    public void consultarSaldo() {
        System.out.println("Se hizo la consulta de saldo del basico");
    }

    @Override
    public void pagarServicio() {
        System.out.println("Se pago el servicio del basico");
    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Se retiro efectivo del basico");
    }

    @Override
    public void transaccionOk(String transaccion) {
        System.out.println("Transaccion Ok");
    }

    @Override
    public void transaccionNoOk(String transaccion) {
        System.out.println("Transaccion no ok");
    }
}
