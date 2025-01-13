

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona persona2 = new Persona("Juan",25,"10109782");
        Persona persona3 = new Persona("Juan",25,"10109783",58.5,1.72);
        //Persona persona4 = new Persona("Anibal", 29);

        //calcular imc
        int imc = persona3.calcularImc();
        if (imc==-1) {
            System.out.println("");
            System.out.println("El imc esta por debajo de 20, es decir: Peso bajo");
        }if (imc==0) {
            System.out.println("El imc esta entre 20 y 25, es decir: Peso saludable");
        }if (imc==1) {
            System.out.println("El imc esta mayor de 25, es decir: Sobrepeso");
        }

        //verificar edad
        if (persona3.esMayorEdad()){
            System.out.println("la persona3 es mayor de edad");
        } else {
            System.out.println("la persona es menor de edad");
        }

        System.out.println(persona3);



    }
}
