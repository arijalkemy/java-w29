package app;

import models.clientes.Basico;
import models.clientes.Cobrador;
import models.clientes.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        //Clientes
        Ejecutivo ejecutivo = new Ejecutivo("Raul");
        Basico basico = new Basico("Andres");
        Cobrador cobrador = new Cobrador("Laura");

        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();

        basico.consultarSaldo();
        basico.realizarPago();
        basico.realizarRetiro();

        cobrador.consultarSaldo();
        cobrador.realizarRetiro();
    }
}
