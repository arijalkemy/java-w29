//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Persona unknown = new Persona();
        Persona matias = new Persona("Matias",12,"34567654",1.90f,60.0f);

        System.out.print(matias);
        System.out.print(unknown);
        System.out.println("Es mayor?..");
        System.out.println(matias.esMayorDeEdad());

        System.out.println("IMC persona:");
        if (matias.calcularIMC() == -1){
            System.out.println("Bajo peso");
        } else if (matias.calcularIMC() == 0) {
            System.out.println("Peso saludable");
        } else if (matias.calcularIMC() == 1) {
            System.out.println("Sobrepeso");
        }
    }



    // Mensaje final
    String mensajeFinal = "Este es el último mensaje";

    // Código que arroja excepción
    int[] numeros = new int[5];
/*
    try {
        // Intentamos asignar un valor a una posición fuera del rango
        numeros[5] = 10;
    } catch (ArrayIndexOutOfBoundsException e) {
        // Capturamos la excepción y mostramos el mensaje de la excepción
        System.out.println("Excepción capturada: " + e.getMessage());
    } finally {
        // Imprimimos el mensaje final
        System.out.println(mensajeFinal);
    }*/
}