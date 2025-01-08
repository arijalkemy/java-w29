import com.bootcamp.Persona;

public class Main {
    public static void main(String[] args) {
        Persona julianCastro = new Persona();
        Persona marceloVieira = new Persona("Marcelo Vieira", "31548887", 37);
        Persona juanCarlos = new Persona("Juan Carlos", 54, "23545153", 70.0, 1.7);
        // no es posible crearlo con parametros de un constructor que no existe

        Integer imc = juanCarlos.cacularIMC();
        System.out.println("El IMC de " + juanCarlos.getNombre() + " es: " + imc);
        String mayorDeEdad = juanCarlos.esMayorDeEdad() ? "Es mayor de edad" : "No es mayor de edad";
        System.out.println(juanCarlos.getNombre() + " tiene " + juanCarlos.getEdad() + " a\u00F1os. " + mayorDeEdad);
        String peso = (imc == -1) ? "Bajo Peso" : (imc == 0) ? "Peso Saludable" : "Sobrepeso";
        System.out.println("Nivel de peso: " + peso);

    }
}