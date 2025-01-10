package org.example;

public class Main {
    public static void main(String[] args) {
        PracticaExcepciones p1 = new PracticaExcepciones();
        //Punto 1
        /*try{
            p1.dividir();
        }catch (Exception e){
            System.out.println("Se ha producido un error");
        }finally {
            System.out.println("Programa finalizado");
        }*/

        //Modificar el programa anterior para que, al producirse el error, en vez de imprimir por
        // consola el mensaje “Se ha producido un error”, lo lance como una excepción de tipo
        // IllegalArgumentException con el mensaje “No se puede dividir por cero”

        //punto 2
        try{
            p1.dividir();
        }catch (ArithmeticException e){
            //System.out.println(exception.getMessage());
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}