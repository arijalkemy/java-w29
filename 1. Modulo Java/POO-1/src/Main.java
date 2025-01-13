import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona persona2 = new Persona("Pepe", 33, "99999999", 1.78, 87);
        Persona persona3 = new Persona("Marta", 22, "12344399");
        //Persona persona4 = new Persona("Marta","12344399");

        int sobrepeso = persona2.calcularIMC();
        switch (sobrepeso) {
            case -1:
                System.out.println("Bajo peso");
                break;

            case 1:
                System.out.println("sobre peso");
                break;
            case 0:
                System.out.println("saludable");
                break;
        }

        if (persona2.esMayorEdad()) {
            System.out.println("Es mayor de edad");
        }else {
            System.out.println("Es menor de edad");
        }

        System.out.println(persona2.toString());


    }
}