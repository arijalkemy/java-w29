package com.meli;

import com.meli.usuarios.Basico;
import com.meli.usuarios.Cobrador;
import com.meli.usuarios.Ejecutivo;

public class Main {

    public static void main(String[] args) {

        Ejecutivo uEjecutivo = new Ejecutivo();

        uEjecutivo.realizarTransferenciaOk();
        uEjecutivo.realizarDepositoNoOk();

        Basico uBasico = new Basico();
        Cobrador uCobrador = new Cobrador();

    }
}
