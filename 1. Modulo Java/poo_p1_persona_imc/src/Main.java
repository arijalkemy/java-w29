public class Main {
    public static void main(String[] args) {
        Persona personaSinAtributos = new Persona();
        Persona personaCon3Atributos = new Persona("Camilo", 23, "123456789");
        Persona personaConTodosAtributos = new Persona("Camilo", 23, "123456789", 84.5, 1.75);

        // No hay constructor con 2 parametros -> Genera error
        // Persona p1 = new Persona("Nombre", 12);

        int imc = personaConTodosAtributos.calcularIMC();
        switch (imc) {
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
        }

        boolean esMayor = personaConTodosAtributos.esMayorDeEdad();
        System.out.println(esMayor ? "Es mayor de edad" : "Es menor de edad");

        System.out.println(personaConTodosAtributos);
    }
}