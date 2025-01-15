package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static String apellido;
    static int edad;
    static boolean matricula;
    static double sueldo;
    static String nombre;

    //Selección de variables acorde a los nombres correctos.
    //static int edad;
    static String direccion;
    static String licencia_de_conducir;



    public static void main(String[] args) {

        //Punto 1 - Declaración de variables y asignación de valores
        apellido="Gomez";
        edad=35;
        matricula=false;
        sueldo=45857.90;
        nombre="Julián";

        //Punto 2 - asignación de valores
        edad=20;
        direccion="cra 22";
        licencia_de_conducir="782js";


        System.out.println("edad: "+edad);
        System.out.println("direccion: "+direccion);
        System.out.println("licencia: "+licencia_de_conducir);

    }
}

