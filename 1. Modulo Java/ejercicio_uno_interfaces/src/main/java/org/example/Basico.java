package org.example;


public class Basico implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo{
    @Override
    public void consultarSaldo() {
        System.out.println("ej1.Basico consulta saldo");
    }

    @Override
    public void pagarServicio() {
        System.out.println("ej1.Basico pagar servicio");
    }

    @Override
    public void retirar() {
        System.out.println("ej1.Basico retirar");
    }

    @Override
    public void transaccionOk() {
        System.out.println("ej1.Basico transaccion Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("ej1.Basico transaccion No ok");
    }
}


