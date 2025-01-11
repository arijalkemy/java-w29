package org.example.Ejercicio1;

import org.example.Ejercicio1.Usuarios.Basico;
import org.example.Ejercicio1.Usuarios.Cobrador;
import org.example.Ejercicio1.Usuarios.Ejecutivo;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Ejecutivo uEjecutivo = new Ejecutivo();

        uEjecutivo.realizarTransferenciaOk();
        uEjecutivo.realizarDepositoNoOk();

        Basico uBasico = new Basico();
        Cobrador uCobrador = new Cobrador();
    }
}