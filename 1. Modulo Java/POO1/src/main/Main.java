package main;

public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona("Juan", 25, "12345678");
        Persona persona2 = new Persona();
        Persona persona3 = new Persona("Jose", 18, "43413241", 70, 1.70);
        System.out.println(persona1);
        System.out.println(persona2);
        System.out.println(persona3);
        System.out.println(persona3.calcularIMC());
        System.out.println("Hello, World!");
    }
}