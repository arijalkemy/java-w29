package org.Ejercicio1;

public class PracticaExcepciones {


    public static void main(String[] args) {
        int a, b;
        a = 0;
        b = 300;

        try{
            if(a==0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }

            double resultado = b/a;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            System.out.println("Se ha producido un error");
        }finally {
            System.out.println("Programa finalizado");
        }

    }
}
