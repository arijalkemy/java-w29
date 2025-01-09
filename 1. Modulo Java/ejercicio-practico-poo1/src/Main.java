//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona persona3Param = new Persona("lucas",25,"41693423");
        Persona personaTodosLosParam = new Persona("Pedro",32,"44693423",75.5,1.74);

        int imc = personaTodosLosParam.cacularIMC();
        if(imc==-1){
            System.out.println("El imc de " + personaTodosLosParam.nombre + " es de bajo peso");
        }else if(imc == 0){
            System.out.println("El imc de " + personaTodosLosParam.nombre + " es de peso saludable");
        }else{
            System.out.println("El imc de " + personaTodosLosParam.nombre + " es de sobrepeso");
        }

        boolean mayorDeEdad = personaTodosLosParam.esMayorDeEdad();

        if(mayorDeEdad){
            System.out.println("Es mayor de edad.");
        }else{
            System.out.println("No es mayor de edad.");
        }

        System.out.println(personaTodosLosParam.toString());
    }
}