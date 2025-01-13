package com.example.demo.abstractClass.ej_1;

public class PagoServicios implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios realizado con exito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar el pago de servicios.");
    }
}
