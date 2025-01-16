package org;

public class Main2 {
    private static int dividendo=5;
    private static int divisor=0;


    public static void main(String[] args) {
    dividir();
    }

    public static void dividir() {
        try{

            if(divisor==0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }

        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }finally {
            System.out.println("Después de la división");
        }
    }

}
