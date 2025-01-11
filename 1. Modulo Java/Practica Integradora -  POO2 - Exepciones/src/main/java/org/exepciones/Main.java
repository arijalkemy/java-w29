package org.exepciones;

/*
* Modificar el programa anterior para que, al producirse el error, en vez de imprimir por consola el mensaje
* “Se ha producido un error”, lo lance como una excepción de tipo IllegalArgumentException con el mensaje
* “No se puede dividir por cero”
* */


import org.exepciones.model.PracticaExcepciones;

public class Main {
    public static void main(String[] args) throws Exception {

        String messageFinal = "Programa finalizado";
        //String messageError = "Se ha producido un error";
        String messageExepcion = "No se puede dividir por cero";
        PracticaExcepciones practice = new PracticaExcepciones();

        /*
        //Ejercicio 1.1

        try {
            practice.calcularCociente();
            System.out.println(messageFinal);
        } catch (Exception e) {
            System.out.println(messageError);
            System.out.println(messageFinal);
        }

        */

        //Ejercicio 1.2
        try {
            practice.calcularCociente();
            System.out.println(messageFinal);
        } catch (Exception e) {
            throw new IllegalArgumentException(messageExepcion);
        }
        finally {
            System.out.println(messageFinal);
        }
    }
}