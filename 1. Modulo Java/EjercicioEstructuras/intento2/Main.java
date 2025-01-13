package intento2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;



public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static void main(String[] args) {
        //Inicio programa para carreras

        Map<String, Object> catUno = new HashMap<String, Object>();
        Map<String, Object> catDos = new HashMap<String, Object>();
        Map<String, Object> catTres = new HashMap<String, Object>();

        catUno.put("nombre", "");
        catUno.put("inscritos", new ArrayList<>());
        catUno.put("descripcion", "");

        catDos.put("nombre", "");
        catDos.put("inscritos", new ArrayList<>());
        catDos.put("descripcion", "");

        catTres.put("nombre", "");  
        catTres.put("inscritos", new ArrayList<>());
        catTres.put("descripcion", "");



        boolean runProgram = true;
        while (runProgram) {
            System.out.println("Menu de opciones");
            System.out.println("1. Mostrar Categorias");
            System.out.println("2. Crear Inscripcion");
            System.out.println("3. Eliminar Inscripcion");
            System.out.println("4. Mostrar Inscripciones por Categoria");
            System.out.println("5. Mostrar Ingresos por Categoria");
            System.out.println("6. Salir");
            System.out.println("Ingrese su opcion:");

            int opcion = scanner.nextInt(); // Limpiando el buffer del scanner
            switch (opcion) {
                case 1://Mostrar Categorias
                    System.out.println("Categoría 1: " + (String) catUno.get("nombre"));
                    System.out.println("Categoría 2: " + (String) catDos.get("nombre"));
                    System.out.println("Categoría 3: " + (String) catTres.get("nombre"));
                    break;
                case 2://Crear Inscripcion
                    break;
                case 3://Eliminar Inscripcion
                    break;
                case 4://Mostrar Inscripciones
                    break;
                case 5://Mostrar Ingresos por Categoria
                    break;
                case 6://Salir
                    runProgram = false;
                default:
                    break;
            } 
        }
    }
}
