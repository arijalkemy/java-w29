public class Main {
    public static void main(String[] args) {
        //Persona persona1 = new Persona();
        Persona persona2 = new Persona("Adrian", 24, "100374");
        Persona persona3 = new Persona("Rossi", 43, "464646", 62.0, 1.62);
        //persona1.calcularIMC();
        //persona2.calcularIMC();
        System.out.println(persona3.calcularIMC());
        //persona1.esMayorDeEdad();
        //persona2.esMayorDeEdad();
        System.out.println(persona3.esMayorDeEdad());

    }
}
