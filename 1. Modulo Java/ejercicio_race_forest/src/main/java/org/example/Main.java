package org.example;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Map<String, String[]> categories = new HashMap<>();
        categories.put("chico", new String[]{"1", "Circuito chico"});
        categories.put("medio", new String[]{"2", "Circuito medio"});
        categories.put("avanzado", new String[]{"3", "Circuito avanzado"});

        Map<Integer, Map<String, Object>> inscripciones = new HashMap<>();

        inscribirParticipante(inscripciones, categories, 1, "chico", "12345678", "Juan", "Pérez", 21, "123456789", "987654321", "A+");
        inscribirParticipante(inscripciones, categories, 2, "medio", "87654321", "Ana", "Gómez", 17, "123123123", "321321321", "B-");
        inscribirParticipante(inscripciones, categories, 3, "avanzado", "11122233", "Luis", "Martínez", 25, "456456456", "654654654", "O+");

        mostrarInscriptosPorCategoria(inscripciones, "chico");
        mostrarInscriptosPorCategoria(inscripciones, "medio");
        mostrarInscriptosPorCategoria(inscripciones, "avanzado");

        desinscribirParticipante(inscripciones, 1);

        calcularMontos(inscripciones);
    }

    private static void inscribirParticipante(Map<Integer, Map<String, Object>> inscripciones, Map<String, String[]> categorias,
                                              int numInscripcion, String categoria, String dni, String nombre, String apellido,
                                              int edad, String celular, String emergencia, String grupoSanguineo) {
        int monto;
        switch (categoria) {
            case "chico":
                monto = (edad < 18) ? 1300 : 1500;
                break;
            case "medio":
                monto = (edad < 18) ? 2000 : 2300;
                break;
            case "avanzado":
                if (edad < 18) {
                    System.out.println("Error: menores de 18 no pueden inscribirse en categoría avanzada.");
                    return;
                }
                monto = 2800;
                break;
            default:
                System.out.println("Categoría no válida.");
                return;
        }

        Map<String, Object> inscripcion = new HashMap<>();
        inscripcion.put("categoria", categoria);
        inscripcion.put("dni", dni);
        inscripcion.put("nombre", nombre);
        inscripcion.put("apellido", apellido);
        inscripcion.put("edad", edad);
        inscripcion.put("celular", celular);
        inscripcion.put("emergencia", emergencia);
        inscripcion.put("grupoSanguineo", grupoSanguineo);
        inscripcion.put("monto", monto);

        inscripciones.put(numInscripcion, inscripcion);

        System.out.println("Participante N°" + numInscripcion + " incripto en la categoria: " + categoria );
    }

    private static void mostrarInscriptosPorCategoria(Map<Integer, Map<String, Object>> inscripciones, String categoria) {
        System.out.println("Inscriptos en la categoría " + categoria + ":");

        for (Map.Entry<Integer, Map<String, Object>> participante : inscripciones.entrySet()) {
            if (participante.getValue().get("categoria").equals(categoria)) {
                System.out.println("Participante N°: " + participante.getKey() + " - Datos: " + participante.getValue());
            }
        }
    }

    private static void desinscribirParticipante(Map<Integer, Map<String, Object>> inscripciones, int numInscripcion) {
        if (inscripciones.remove(numInscripcion) != null) {
            System.out.println("Participante con número " + numInscripcion + " desinscripto.");

            for (Map.Entry<Integer, Map<String, Object>> inscripcion : inscripciones.entrySet()) {
                System.out.println("Participantes aun inscriptos: " + inscripcion.getKey() + " en la categoria: " + inscripcion.getValue().get("categoria"));
            }

        } else {
            System.out.println("No se encontró el número de inscripción " + numInscripcion );
        }
    }

    private static void calcularMontos(Map<Integer, Map<String, Object>> inscripciones) {
        Map<String, Integer> montosPorCategoria = new HashMap<>();
        int total = 0;

        for (Map.Entry<Integer, Map<String, Object>> entry : inscripciones.entrySet()) {
            String categoria = (String) entry.getValue().get("categoria");
            int monto = (int) entry.getValue().get("monto");
            montosPorCategoria.put(categoria, montosPorCategoria.getOrDefault(categoria, 0) + monto);
            total += monto;
        }

        for (Map.Entry<String, Integer> entry : montosPorCategoria.entrySet()) {
            System.out.println("Recaudado en categoría " + entry.getKey() + ": $" + entry.getValue());
        }
        System.out.println("Recaudado total: $" + total);
    }
}