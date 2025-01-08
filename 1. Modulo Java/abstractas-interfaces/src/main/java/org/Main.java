package org;

import org.ejercicio1.Basic;
import org.ejercicio1.Cobrador;
import org.ejercicio1.Ejecutivo;
import org.ejercicio2.Curriculum;
import org.ejercicio2.Imprimible;
import org.ejercicio2.Informe;
import org.ejercicio2.LibroPDF;
import org.ejercicio3.Animal;
import org.ejercicio3.Gato;
import org.ejercicio3.Perro;
import org.ejercicio3.Vaca;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        ejercicio1();
        ejercicio2();
//        ejercicio3();

    }

    public static void ejercicio1() {
        Basic basic = new Basic();
        basic.setSaldoTotal(500000);
        basic.hacerConsultaSaldo();

        Cobrador cobrador = new Cobrador();
        cobrador.setSaldoTotal(500000);
        cobrador.hacerConsultaSaldo();

        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.setSaldoTotal(500000);
        ejecutivo.hacerTrasferencia(20000);
    }

    public static void ejercicio2() {
        Informe informe = new Informe("texto", 2, "Andres", "David");
        Imprimible.imprimir(informe);

        Curriculum curriculum = new Curriculum("Andres", "Largo", "1010", "27",
                new ArrayList<>(Arrays.asList("Java", "Go", "Springboot")));
        Imprimible.imprimir(curriculum);

        LibroPDF libroPDF = new LibroPDF("Ficción", 200, "Andres", "Un nuevo libro");
        Imprimible.imprimir(libroPDF);
    }

    public static void ejercicio3() {
        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();
        gato.comerHierba();

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerHierba();

        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();
        perro.comerHierba();
        comerAnimal(perro);

    }

    public static void comerAnimal(Animal animal) {
        if (animal instanceof Gato) {
            ((Gato) animal).comerCarne();
        } else if (animal instanceof Perro) {
            ((Perro) animal).comerCarne();
        } else if (animal instanceof Vaca) {
            ((Vaca) animal).comerHierba();
        }
    }
}