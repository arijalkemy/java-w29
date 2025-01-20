package org.example;

import Ex1.Clases.Basic;
import Ex1.Clases.Ejecutivo;
import Ex2.ArchivoPDF;
import Ex2.Curriculum;
import Ex2.Imprimible;
import Ex2.Informe;
import Ex3.Clases.Gato;
import Ex3.Clases.Perro;
import Ex3.Clases.Vaca;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        // Ejercicio 1
        System.out.println("Ejercicio 1");
        Basic basic = new Basic();
        basic.consultarSaldo();
        basic.pagarServicio("Luz");

        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.hacerDeposito();
        ejecutivo.transaccionNoOk();
        ejecutivo.hacerDeposito();
        ejecutivo.transaccionOk();

        System.out.println("--------");

        // Ejercicio 2
        System.out.println("Ejercicio 2");
        ArchivoPDF mipdf = new ArchivoPDF("Pepe",10,"How to leran JAVA");
        Curriculum micv= new Curriculum("Matias","djfakfkasdjfad","Leal",25, Arrays.asList("Java","Python","Dart"));
        Informe informe = new Informe("Esto es un informe...",12,"Matias","Gonzalo");
        Imprimible.imprimir(mipdf);
        Imprimible.imprimir(micv);
        Imprimible.imprimir(informe);

        // Ejercicio 3
        System.out.println("--------");
        System.out.println("Ejercicio 3");

        Gato blanco = new Gato("Blanca");
        Perro perro = new Perro();
        Vaca vaca = new Vaca();
        System.out.println("El gato...");
        blanco.sonido();
        System.out.println("El perro...");
        perro.sonido();
        System.out.println("El vaca...");
        vaca.sonido();

    }
}