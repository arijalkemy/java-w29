package app;

import domain.Person;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        Person person2 = new Person("Juan Perez", 23, "3430530");

        Person person3 = new Person(
                "Juan Perez",
                23,
                "3430530",
                48,
                1.69f
        );

        int imcResult = person3.calcIMC();
        boolean isAdult = person3.isAdult();

        System.out.println("---------------------");
        System.out.println(person3.toString());
        System.out.println("---------------------");
        System.out.println("Resultados");
        System.out.println("****************************");
        System.out.println("Segun tu IMC tienes: " + IMCInText(imcResult));
        System.out.println(isAdult ? "Eres mayor de edad" : "Eres menor de edad");

    }

    private static String IMCInText(int imcResult) {
        return switch (imcResult) {
            case -1 -> "Bajo peso";
            case 0 -> "Peso saludable";
            case 1 -> "Sobrepeso";
            default -> "Peso incorrecto";
        };
    }
}
