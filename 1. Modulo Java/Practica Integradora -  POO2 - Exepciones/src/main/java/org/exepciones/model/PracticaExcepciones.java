package org.exepciones.model;
/*
* Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300 de tipo int.
* Calcular el cociente de b/a. Controlar la excepción que se lanza indicando el mensaje “Se ha producido un error”.
* Al final del programa siempre deberá indicar el mensaje “Programa finalizado”
*/
public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;

    public int calcularCociente(){

        return this.b / this.a;

    }
}