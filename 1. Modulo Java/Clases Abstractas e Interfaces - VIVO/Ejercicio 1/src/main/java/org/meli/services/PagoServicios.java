package org.meli.services;

import org.meli.interfaces.Transaccion;

public class PagoServicios implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Pago de servicios exitoso.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al pagar el servicio.");
    }
}
