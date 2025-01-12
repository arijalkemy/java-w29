package ejercicio1;

import ejercicio1.usuarios.Basico;
import ejercicio1.usuarios.Cobrador;
import ejercicio1.usuarios.Ejecutivo;

public class Main {

    public static void main(String[] args) {

        Ejecutivo uEjecutivo = new Ejecutivo();

        uEjecutivo.realizarTransferenciaOk();
        uEjecutivo.realizarDepositoNoOk();

        Basico uBasico = new Basico();

        uBasico.consultarSaldo(-1);
        uBasico.pagarServicio(700);
        uBasico.pagarServicio(500);

        Cobrador uCobrador = new Cobrador();
        uCobrador.consultarSaldo(-1);
        uCobrador.retirarEfectivo(500);

    }
}
