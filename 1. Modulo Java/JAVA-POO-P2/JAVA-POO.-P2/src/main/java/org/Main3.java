package org;

public class Main3 {
    public static void main(String[] args) {

        //Mensaje final
        String mensajeFinal = "Este es el último mensaje";

        //Código que arroja excepción
        try{
        int[] numeros = new int[5];
        numeros[5] = 10;}
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }finally {

            System.out.println("Fin del programa");
        }

    }
}
