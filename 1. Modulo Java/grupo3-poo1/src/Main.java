//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona juan = new Persona("Juan", 37, "2948848");
        Persona josefina = new Persona("Josefina", 20, "202020", 57.1, 1.80);

        josefina.calcularPeso();
        System.out.println(verificarEdad(josefina.esMayorDeEdad()));
        System.out.println(verificarIMC(josefina.calcularPeso()));
        System.out.println(josefina);
    }

    private static String verificarIMC(int valor){
        return switch (valor){
            case -1 -> "Bajo peso";
            case 0 -> "Peso normal";
            case 1 -> "Sobrepeso";
            default -> "Valor no válido";
        };
    }

    private static String verificarEdad(boolean valor){
        if (valor){
            return "Es mayor de edad";
        } else {
            return "Es menor de edad";
        }
    }

}