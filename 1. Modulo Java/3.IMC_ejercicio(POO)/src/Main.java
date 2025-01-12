import java.io.FileInputStream;
import java.io.FileNotFoundException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person person_empty = new Person();
        Person person_middle = new Person("Jose",18,"123");
        Person person_full = new Person("David",23,"567",62.5,1.73);

        System.out.println(person_empty.toString());
        System.out.println(person_empty.calcularIMC());

        int imc = person_full.calcularIMC();
        boolean is_older = person_full.esMayordeEdad();

        switch (imc){
            case -1 -> System.out.println("IMC: Bajo de Peso");
            case 0 -> System.out.println("IMC: Peso Saludable");
            case 1 -> System.out.println("IMC: Sobrepeso");
        }
    }


}