public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona();
        Persona persona2 = new Persona("Manuel", 22, "000000");
        Persona persona3 = new Persona("Luis", 30, "000000", 65, 1.71);

        System.out.println("---------------------");
        if (persona.cacularIMC(65.0, 1.72) == -1) {
            System.out.println("La persona está baja de peso con un indice inferior a 20 en su IMC");
        } else if (persona.cacularIMC(65.0, 1.72) == 0) {
            System.out.println("La persona tiene un peso saludable con un indice entre 20 y 25 en su IMC");
        }else{
            System.out.println("La persona tiene sobrepeso con un indice mayor a 25 en su IMC");
        }
        System.out.println("---------------------");
        if (persona2.esMayorDeEdad(16)){
            System.out.println("La persona 2 es mayor de edad");
        }else{
            System.out.println("La persona 2 es menor de edad");
        }
        System.out.println("---------------------");
        System.out.println("Los datos de la persona 3 son: ");
        System.out.println(persona3.toStringData());
    }
}