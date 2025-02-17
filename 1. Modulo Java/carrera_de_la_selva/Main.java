package com.example.demo.carrera_de_la_selva;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static Map<Integer, String[]> categorias = new HashMap<>();
    static Map<Integer, String[]> participantes = new HashMap<>();
    static Map<Integer, String[]> inscritos = new HashMap<>();

    public static void main(String[] args) {

        categorias.put(2, new String[]{"2 km por selva y arroyos", "1300", "1500"});
        categorias.put(5, new String[]{"5 km por selva, arroyos y barro", "2000", "2300"});
        categorias.put(10, new String[]{"10 km por selva, arroyos, barro y escalada en piedra", "2800"});

        participantes.put(1, new String[]{"44690195", "Eliseo", "Sanz", "21", "1123563167", "", "A+", "3"});
        participantes.put(2, new String[]{"46666133", "Facundo", "Gonzalez", "16", "1123563167", "", "A+", "1"});
        participantes.put(3, new String[]{"44690160", "Lourdes", "Caceres", "21", "1123563999", "", "A-", "2"});

        inscribirParticipante(participantes, inscritos);

        String[] nuevoParticipante = {"12345678", "Nuevo", "Participante", "22", "1122334455", "", "B+", "5"};
        participantes.put(4, nuevoParticipante);
        inscribirParticipante(participantes, inscritos);

        // Categorias : [2, 5, 10]
        System.out.println("Inscriptos en categoría 5:");
        mostrarInscriptosPorCategoria(5);

        desinscribirParticipante(2);
        System.out.println("Inscriptos después de desinscribir al participante 2:");
        mostrarInscriptosPorCategoria(1);

        System.out.println("Monto total recaudado: " + calcularMontoRecaudado());
    }

    public static void inscribirParticipante(Map<Integer, String[]> participante, Map<Integer, String[]> inscritos) {
        for (Map.Entry<Integer, String[]> entry : participante.entrySet()) {
            int id = entry.getKey();
            String[] datos = entry.getValue();

            if (!inscritos.containsKey(id) && verifyInscription(datos)) {
                inscritos.put(id, datos);
            }
        }
    }

    public static void desinscribirParticipante(int id) {
        inscritos.remove(id);
    }

    public static boolean verifyInscription(String[] participantData) {
        return !(Integer.parseInt(participantData[3]) < 18 && (participantData[7].equals("3")));
    }

    public static void mostrarInscriptosPorCategoria(int categoria) {
        for (Map.Entry<Integer, String[]> entry : inscritos.entrySet()) {
            String[] datos = entry.getValue();
            if (Integer.parseInt(datos[7]) == categoria) {
                System.out.println("ID: " + entry.getKey() + ", Datos: " + String.join(", ", datos));
            }
        }
    }

    public static int calcularMontoRecaudado() {
        int totalRecaudado = 0;
        for (Map.Entry<Integer, String[]> entry : inscritos.entrySet()) {
            String[] datos = entry.getValue();
            int edad = Integer.parseInt(datos[3]);
            int categoria = Integer.parseInt(datos[7]);

            if (categorias.containsKey(categoria)) {
                String[] detallesCategoria = categorias.get(categoria);
                int monto = edad >= 18 ? Integer.parseInt(detallesCategoria[2]) : Integer.parseInt(detallesCategoria[1]);
                totalRecaudado += monto;
            }
        }
        return totalRecaudado;
    }
}
