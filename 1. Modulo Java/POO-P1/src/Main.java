public class Main {

    public static void main(String[] args) {

        Persona p1 = new Persona("Dylan",24,42562766);
        Persona p2 = new Persona("Juan",22);

        int b= p1.calcularIMC();
        System.out.println("El IMC de la persona es "+ b);
        Boolean a = p1.esMayorDeEdad();
        if(a){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }
        String c = p1.toString();
        System.out.println(c);
    }
}
