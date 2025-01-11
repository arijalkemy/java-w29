package org.example.Ejercicio1.transacciones;

public class PagosServicios implements Transaccion {

    @Override
    public void ok() {
        System.out.println("Realizando Pagos servicio : Ok");
    }

    @Override
    public void noOk() {
        System.out.println("Realizando Pagos Servicios: no Ok");
    }
}
