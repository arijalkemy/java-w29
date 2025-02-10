package Operaciones;


import Interfaces.Transaccion;

public class PagoServicios implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose pago de servicios");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Pago de servicios fallido");
    }
}