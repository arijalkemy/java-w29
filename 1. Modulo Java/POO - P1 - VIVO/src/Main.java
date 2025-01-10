import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Pepe", 25, "40000000", 90.0F, 1.85F);

        // Check de edad
        System.out.println(persona.esMayorDeEdad() ? "Es mayor de edad" : "Es menor de edad");

        // Check de imc
        switch (persona.calcularIMC()) {
            case -1:
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
        }

        System.out.println(persona);
    }


}