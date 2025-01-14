public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Erik Calvillo",25,"CMGJPOIDHFJLGGR4");
        Persona persona3 = new Persona("Paulina García",1.60,15,"RENM9043HDFGLROO",55);
        System.out.println(persona3);
        int calculoIMC = persona3.calcularIMC();
        switch (calculoIMC){
            case -1:
                System.out.println("IMC: Bajo de peso");
                break;
            case 0:
                System.out.println("IMC: Peso saludable");
                break;
            case 1:
                System.out.println("IMC: Sobrepeso");
                break;
        }
        System.out.println("Mayor de edad: "+persona3.esMayorDeEdad());


    }
}