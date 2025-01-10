package org.example;

public class PracticaExcepciones {
    //Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300 de tipo int.
    public int a=0;
    public int b=300;

    public PracticaExcepciones() {
    }

    //Calcular el cociente de b/a. Controlar la excepción que se lanza indicando el mensaje
    // “Se ha producido un error”. Al final del programa siempre deberá indicar el mensaje
    //“Programa finalizado”

    //Punto1
    public double dividir(){
        return this.b/this.a;

    }
}
