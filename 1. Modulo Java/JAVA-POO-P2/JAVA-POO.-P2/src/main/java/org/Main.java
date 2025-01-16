package org;

public class Main {
    public static void main(String[] args) {

        System.out.println("Antes de hacer la división");
        try{

            double division=5/0;

        }catch (ArithmeticException e){
            System.out.println("Error en el división: " + e.getMessage());
        }finally {
            System.out.println("Después de la división");
        }
    }
}