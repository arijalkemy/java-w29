package Transaccion;

import Transaccion.Transaccionable;

public class ConsultaSaldo implements Transaccionable {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo exitosa");
    }

    @Override
    public void transaccionError() {
        System.out.println("Error en la consulta de saldo");
    }
}
