public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("nicolas", 23, "43082497");
        Persona persona3 = new Persona("aixa", 26, "41872444", 66.5, 1.58);

        int imc = persona3.calcularIMC();
        switch (imc){
            case -1:
                System.out.println("Imc= "+ imc);
                System.out.println("Bajo peso");
                break;
            case 0:
                System.out.println("Imc= "+ imc);
                System.out.println("Peso saludable");
                break;
            case 1:
                System.out.println("Imc= "+ imc);
                System.out.println("Sobrepeso");
                break;
        }

        System.out.println(persona3.esMayorDeedad());
        System.out.println(persona3.toString());

    }
}
