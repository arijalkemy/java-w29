package org.example;

public class Main {
    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.depositar();
        ejecutivo.transaccionNoOk();

        Basico basico = new Basico();
        basico.consultarSaldo();
        basico.pagarServicio();

        Cobradores cobradores = new Cobradores();
        cobradores.retirar();
        cobradores.consultarSaldo();
    }
}
