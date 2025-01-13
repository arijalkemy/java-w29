package com.exercises;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        Persona personaVacia = new Persona();
        Persona persoanaDos = new Persona("test", 20, "1234");
        Persona persoanaTres = new Persona("test", 20, "1234", 73.4, 1.72);
        // Persona persoanaCuatro = new Persona("test", 20);

        // System.out.println(persoanaTres.calcularIMC());

        switch (persoanaTres.calcularIMC()) {
            case -1:
                System.out.println("Bajo Peso");
                break;

            case 1:
                System.out.println("Sobrepeso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;

            default:
                break;
        }

        System.out.println("Mayor de edad: " + persoanaTres.esMayorDeEdad());

        System.out.println(persoanaTres.toString());

    }
}
