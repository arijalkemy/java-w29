public class Main {
    public static void main(String[] args) {

        // Crear un objeto de la clase Persona
        Persona persona = new Persona("Juan", 20, "12345678", 70, 1.75);


        // Mostrar los datos de la persona
        System.out.println(persona);
        System.out.println("Datos calculados: ");


        // Mostrar el IMC de la persona
        switch (persona.calcularIMC()) {
            case -1 -> System.out.println("Esta por debajo de su peso ideal");
            case 0 -> System.out.println("Esta en su peso ideal");
            case 1 -> System.out.println("Esta por encima de su peso ideal");
        }


        // Mostrar si la persona es mayor de edad
        if (persona.esMayorDeEdad()) {
            System.out.println("Es mayor de edad");
        } else {
            System.out.println("Es menor de edad");
        }
    }
}