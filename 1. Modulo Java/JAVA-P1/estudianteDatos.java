public class estudianteDatos {

    static String apellido;
    static int edad;
    static boolean matricula;
    static String sueldo;
    static String nombre;

    //Selección de variables acorde a los nombres correctos.
    static int edad;
    static String direccion;
    static boolean licencia_de_conducir;
    static int cantidad-de-hijos;


    public static void main(String[] args) {

        //Punto 1 - Declaración de variables y asignación de valores
        apellido="Gomez";
        edad=35;
        sueldo=45857.90;
        matricula=false;
        nombre="Julián";

        //Punto 2 - asignación de valores
        edad=20;
        direccion="cra 22";
        licencia_de_conducir="782js";
        cantidad-de-hijos=2;

        System.out.println("edad: "+edad);
        System.out.println("direccion: "+direccion);
        System.out.println("licencia: "+licencia_de_conducir);

    }
}