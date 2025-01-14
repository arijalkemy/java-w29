public class Main {
    public static void main(String[] args) {

        Persona persona = new Persona();
        Persona personaCon3 = new Persona("julia",26,"54675123");
        Persona personaConTodo = new Persona("Leo",10,"12345678",40.5,153);

        int imc = personaConTodo.calcularIMC();

        switch(imc) {
            case -1:
                System.out.println("El IMC es de: "+ imc + " Bajo peso");
                break;
            case 0:
                System.out.println("El IMC es de: "+ imc + " Peso saludable");
                break;
            case 1:
                System.out.println("El IMC es de: "+ imc + " Sobrepeso");
                break;
            default:
                System.out.println("No se pudo calcular el IMC correctamente.");
                break;
        }

        if (personaConTodo.esMayorDeEdad()) {
            System.out.println("Es mayor de edad.");
        } else {
            System.out.println( "No es mayor de edad.");
        }

        System.out.println(personaConTodo.toString());

    }
}