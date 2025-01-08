package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {

        // circuitos
        HashMap<String, String> circuitoChico = new HashMap<>();
        HashMap<String, String> circuitoMedio = new HashMap<>();
        HashMap<String, String> circuitoAvanzado = new HashMap<>();

        circuitoChico.put("Circuito chico", "2 km por selva y arroyos.");
        circuitoMedio.put("Circuito medio", "5 km por selva, arroyos y barro.");
        circuitoAvanzado.put("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        HashMap<Integer, HashMap<String, String>> circuitos = new HashMap<>();
        circuitos.put(1, circuitoChico);
        circuitos.put(2, circuitoMedio);
        circuitos.put(3, circuitoAvanzado);

        // participantes
        HashMap<Integer, ArrayList<String>> participantes = new HashMap<>();
        ArrayList<String> participante1 = new ArrayList<>(Arrays.asList("1342134", "Jose", "Bernal", "17", "314189574", "431412341", "O+"));
        ArrayList<String> participante2 = new ArrayList<>(Arrays.asList("1234234", "Juan", "Bernal", "22", "314189574", "431412341", "A+"));
        ArrayList<String> participante3 = new ArrayList<>(Arrays.asList("1364365", "Fernanda", "Bernal", "28", "314189574", "431412341", "B+"));

        participantes.put(1, participante1);
        participantes.put(2, participante2);
        participantes.put(3, participante3);

        Map<Integer, List<HashMap<Integer, ArrayList<Object>>>> inscripciones = new HashMap<>();

        inscripciones.put(1, crearInscripcion(1, participante1));
        inscripciones.put(2, crearInscripcion(2, participante2));
        inscripciones.put(3, crearInscripcion(3, participante3));

        imprimirInscripciones(inscripciones);
        System.out.println(totalRecaudado(circuitos, inscripciones));

    }

    public static String totalRecaudado(HashMap<Integer, HashMap<String, String>> circuitos, Map<Integer, List<HashMap<Integer, ArrayList<Object>>>> inscripciones){
        int total = 0;
        int cat1 = 0;
        int cat2 = 0;
        int cat3 = 0;

        for (Map.Entry<Integer, List<HashMap<Integer, ArrayList<Object>>>> entry : inscripciones.entrySet()) {
            List<HashMap<Integer, ArrayList<Object>>> datosLista = entry.getValue();

            for (HashMap<Integer, ArrayList<Object>> datos : datosLista) {
                for (Map.Entry<Integer, ArrayList<Object>> innerEntry : datos.entrySet()) {
                    ArrayList<Object> inscripcion = innerEntry.getValue();
                    int precio = (int) inscripcion.get(2);

                    total += precio;

                    int categoria = (int) inscripcion.get(0);
                    if (categoria == 1) {
                        cat1 += precio;
                    } else if (categoria == 2) {
                        cat2 += precio;
                    } else if (categoria == 3) {
                        cat3 += precio;
                    }
                }
            }
        }

        return String.format("Total recaudado: %d\n"+circuitos.get(1).keySet().iterator().next()+": %d\n"+circuitos.get(2).keySet().iterator().next()+": %d\n"+circuitos.get(3).keySet().iterator().next()+": %d", total, cat1, cat2, cat3);
    }


    public static List<HashMap<Integer, ArrayList<Object>>> crearInscripcion(int categoria, ArrayList<String> participante) {
        int nroInscripcion = 1;
        List<HashMap<Integer, ArrayList<Object>>> inscripcion = new ArrayList<>();

        int edad = parseInt(participante.get(3));
        int precio = 0;

        switch (categoria) {
            case 1:
                if (edad < 18) {
                    precio = 1300;
                } else {
                    precio = 1500;
                }
                break;
            case 2:
                if (edad < 18) {
                    precio = 2000;
                } else {
                    precio = 2300;
                }
                break;
            case 3:
                if (edad > 18) {
                    precio = 2800;
                }
                break;
            default:
                System.out.println("Categoría no válida");
                break;
        }

        if (precio > 0) {
            HashMap<Integer, ArrayList<Object>> datos = new HashMap<>();
            datos.put(nroInscripcion, new ArrayList<>(Arrays.asList(categoria, participante, precio)));
            inscripcion.add(datos);
        }

        return inscripcion;
    }

    public static void imprimirInscripciones(Map<Integer, List<HashMap<Integer, ArrayList<Object>>>> inscripciones) {
        for (Map.Entry<Integer, List<HashMap<Integer, ArrayList<Object>>>> entry : inscripciones.entrySet()) {
            List<HashMap<Integer, ArrayList<Object>>> datosLista = entry.getValue();

            for (HashMap<Integer, ArrayList<Object>> datos : datosLista) {
                for (Map.Entry<Integer, ArrayList<Object>> innerEntry : datos.entrySet()) {
                    ArrayList<Object> inscripcion = innerEntry.getValue();
                    int categoria = (int) inscripcion.get(0);
                    ArrayList<String> participante = (ArrayList<String>) inscripcion.get(1);
                    int precio = (int) inscripcion.get(2);

                    System.out.println("Número de inscripción: " + innerEntry.getKey());
                    System.out.println("Categoría: " + categoria);
                    System.out.println("Participante: " + participante.get(1) + " " + participante.get(2));
                    System.out.println("Edad: " + participante.get(3));
                    System.out.println("Precio: " + precio);
                    System.out.println("----------------------------");
                }
            }
        }
    }
}
