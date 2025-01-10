package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona();
        Persona persona2 = new Persona("juan", 18, "122313");
        Persona persona3 = new Persona("juan", 24, "122313", 1.80, 4.0);


        System.out.println("IMC de " + persona3.getNombre() + " : " + persona3.calcularIMC());
        int imc = persona3.calcularIMC();
        switch (imc) {
            case -1 -> System.out.println("Bajo de peso");
            case 0 -> System.out.println("Peso normal");
            case 1 -> System.out.println("Sobre peso");
            default -> System.out.println("Imc incorrecta");
        }

        boolean mayorEdad = persona3.mayorEdad();
        String mensaje = mayorEdad ? "Mayor de edad" : "Menor de edad";


    }
}