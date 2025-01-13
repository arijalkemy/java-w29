package com.exercise_java_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Crear 3 objetos de tipo categoría (uno por cada categoría) con sus
 * respectivos datos.
 * Lista de mapas: (categoria-mapa).
 * 
 * Crear un nuevo participante e inscribirlo en una categoría. Calcular el monto
 * de inscripción que deberá abonar (Por ejemplo: si el participante se inscribe
 * a la categoría Circuito chico y tiene 21 años, el monto a abonar es de
 * $1500).
 * lista de mapas: (inscripcion-mapa)
 * 
 * Inscribir al azar algunos participantes en diferentes categorías (al menos
 * uno en cada una).
 * lista de mapas: (inscripcion-mapa)
 * 
 * Mostrar por pantalla todos los inscriptos a una determinada categoría con sus
 * correspondientes datos y número de inscripción.
 * Desinscribir a un participante. Mostrar como queda la lista de inscriptos en
 * la categoría donde se encontraba.
 * Calcular el monto total recaudado por cada categoría y el total de toda la
 * carrera incluyendo todas las categorías.
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        Map<Integer, Map<String, Object>> categorias = new HashMap<>();
        Map<String, Object> circuitoChico = new HashMap<>();
        circuitoChico.put("nombre", "Circuito chico");
        circuitoChico.put("distancia", "2 km ");
        circuitoChico.put("terreno", "selva y arroyos");
        categorias.put(0, circuitoChico);

        Map<String, Object> circuitoMedio = new HashMap<>();
        circuitoMedio.put("nombre", "Circuito medio");
        circuitoMedio.put("distancia", "5 km ");
        circuitoMedio.put("terreno", "selva, arroyos y barro.");
        categorias.put(1, circuitoMedio);

        Map<String, Object> circuitoAvanzado = new HashMap<>();
        circuitoAvanzado.put("nombre", "Circuito avanzado");
        circuitoAvanzado.put("distancia", "10 km ");
        circuitoAvanzado.put("terreno", "selva, arroyos, barro y escalada en piedra.");
        categorias.put(2, circuitoAvanzado);

        List<Map<String, Object>> inscripciones = new ArrayList<>();
        Map<String, Object> inscripcion0 = new HashMap<>();
        inscripcion0.put("numeroInscripcion", 3);
        inscripcion0.put("categoria", 1);
        inscripcion0.put("dni", 2);
        inscripcion0.put("nombre", "Sergio");
        inscripcion0.put("apellido", "Ramirez");
        inscripcion0.put("edad", 50);
        inscripcion0.put("celular", "000");
        inscripcion0.put("emergencia", "222");
        inscripcion0.put("grupoSanguineo", "D+");
        inscripciones.add(inscripcion0);

        Map<String, Object> inscripcion2 = new HashMap<>();
        inscripcion2.put("numeroInscripcion", 1);
        inscripcion2.put("categoria", 2);
        inscripcion2.put("dni", 3);
        inscripcion2.put("nombre", "Fabiana");
        inscripcion2.put("apellido", "Jimenez");
        inscripcion2.put("edad", 20);
        inscripcion2.put("celular", "222");
        inscripcion2.put("emergencia", "777");
        inscripcion2.put("grupoSanguineo", "A+");
        inscripciones.add(inscripcion2);

        Map<String, Object> inscripcion3 = new HashMap<>();
        inscripcion3.put("numeroInscripcion", 1);
        inscripcion3.put("categoria", 3);
        inscripcion3.put("dni", 1);
        inscripcion3.put("nombre", "Juan");
        inscripcion3.put("apellido", "Zaga");
        inscripcion3.put("edad", 15);
        inscripcion3.put("celular", "777");
        inscripcion3.put("emergencia", "333");
        inscripcion3.put("grupoSanguineo", "B-");
        inscripciones.add(inscripcion3);

        // calculo de valores para las incripciones

        System.out.println("\n\n Inscripciones  \n");

        for (Map<String, Object> inscripcion : inscripciones) {
            System.out.println("Inscripcion: " + inscripcion.get("numeroInscripcion"));
            System.out.println("Nombre: " + inscripcion.get("nombre"));
            String id = inscripcion.get("categoria").toString();
            switch (id) {
                case "1":
                    if (Integer.parseInt(inscripcion.get("edad").toString()) >= 18) {
                        inscripcion.put("monto", 1500);
                    } else {
                        inscripcion.put("monto", 1300);
                    }
                    break;
                case "2":
                    if (Integer.parseInt(inscripcion.get("edad").toString()) >= 18) {
                        inscripcion.put("monto", 2300);
                    } else {
                        inscripcion.put("monto", 2000);
                    }
                    break;
                case "3":
                    if (Integer.parseInt(inscripcion.get("edad").toString()) >= 18) {
                        inscripcion.put("monto", 2800);
                    } else {
                        // si es menor se borra la inscripción
                        inscripcion.clear();
                    }
                    break;

                default:
                    break;
            }
        }

        System.out.println("\n\n Inscripciones con valores y luego de desinscribir un participante \n");

        Map<String, Integer> montos = new HashMap<>();

        int total = 0;

        for (Map<String, Object> inscripcion : inscripciones) {
            if (!inscripcion.isEmpty()) {
                System.out.println("Inscripcion: " + inscripcion.get("numeroInscripcion"));
                System.out.println("Nombre: " + inscripcion.get("nombre"));
                System.out.println("Edad: " + inscripcion.get("edad"));
                System.out.println("Monto: " + inscripcion.get("monto"));
                int monto = Integer.parseInt(inscripcion.get("monto").toString());
                int id = Integer.parseInt(inscripcion.get("categoria").toString());

                Map<String, Object> categoria = categorias.get(id - 1);
                if (!categoria.isEmpty()) {

                    int currentValue = montos.getOrDefault(categoria.get("nombre").toString(), 0);
                    if (currentValue > 0) {

                        montos.put(categoria.get("nombre").toString(), currentValue + monto);
                    } else {

                        montos.put(categoria.get("nombre").toString(), monto);
                    }

                    System.out.println("Categoria: " + categoria.get("nombre").toString() + "\n");
                }
            }
        }

        System.out.println("\n Valores por categoria \n\n");

        for (Map.Entry<String, Integer> particularMonto : montos.entrySet()) {
            String clave = particularMonto.getKey();
            int value = particularMonto.getValue();

            System.out.println(clave + ":" + value + "\n");
            total += value;
        }
        System.out.println("\n Valor Total \n\n");
        System.out.println("Total: " + total);
    }
}
