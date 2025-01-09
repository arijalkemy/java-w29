package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<String, List<String>> categorias = new HashMap<>();
        List<String> chico = new ArrayList<>();
        chico.add("Circuito Chico");
        chico.add("Dos Kilómetros por selva y arroyos");
        categorias.put("Chico", chico);

        List<String> medio = new ArrayList<>();
        medio.add("Circuito Medio");
        medio.add("5 Kilómetros por selva, arroyos y barro");
        categorias.put("Medio", medio);

        List<String> avanzado = new ArrayList<>();
        avanzado.add("Circuito Avanzado");
        avanzado.add("10 km por selva, arroyos, barro y escalada en piedra");
        categorias.put("Avanzado", avanzado);

        List<Map<String, Object>> inscripcionesChico = new ArrayList<>();
        List<Map<String, Object>> inscripcionesMedio = new ArrayList<>();
        List<Map<String, Object>> inscripcionesAvanzado = new ArrayList<>();

        Map<String, Object> participante1 = crearParticipante("12345345", "46765908", "Daniel", "Fernandez", 20);
        Map<String, Object> participante2 = crearParticipante("12345375", "49876234", "Carlos", "Arreguez", 17);
        Map<String, Object> participante3 = crearParticipante("12345390", "20768934", "Ana", "Lopez", 56);

        inscribirAleatoriamente(inscripcionesChico, inscripcionesMedio, inscripcionesAvanzado, participante1, participante2, participante3);

        System.out.println("Inscriptos en 'Chico':");
        mostrarInscriptos(inscripcionesChico);

        desinscribirParticipante(inscripcionesChico, participante1);
        System.out.println("\nInscriptos en 'Chico' después de desinscribir:");
        mostrarInscriptos(inscripcionesChico);

        int totalChico = calcularMontoTotal(inscripcionesChico, "Chico");
        int totalMedio = calcularMontoTotal(inscripcionesMedio, "Medio");
        int totalAvanzado = calcularMontoTotal(inscripcionesAvanzado, "Avanzado");
        int totalGeneral = totalChico + totalMedio + totalAvanzado;

        System.out.println("\nMonto total recaudado en 'Chico': " + totalChico);
        System.out.println("Monto total recaudado en 'Medio': " + totalMedio);
        System.out.println("Monto total recaudado en 'Avanzado': " + totalAvanzado);
        System.out.println("Monto total de la carrera: " + totalGeneral);
    }

    public static Map<String, Object> crearParticipante(String numero, String dni, String nombre, String apellido, int edad) {
        Map<String, Object> participante = new HashMap<>();
        participante.put("Número de Participante", numero);
        participante.put("DNI", dni);
        participante.put("Nombre", nombre);
        participante.put("Apellido", apellido);
        participante.put("Edad", edad);
        participante.put("Celular", "3517894534");
        participante.put("Número de Emergencia", "3512356785");
        participante.put("Grupo Sanguíneo", "O+");
        return participante;
    }

    public static void inscribirAleatoriamente(List<Map<String, Object>> chico, List<Map<String, Object>> medio, List<Map<String, Object>> avanzado, Map<String, Object> participante1, Map<String, Object> participante2, Map<String, Object> participante3) {
        chico.add(participante1);
        participante1.put("Monto", calcularMonto("Chico", participante1));
        participante1.put("Inscripcion", chico.size());

        medio.add(participante2);
        participante2.put("Monto", calcularMonto("Medio", participante2));
        participante2.put("Inscripcion", medio.size());

        avanzado.add(participante3);
        participante3.put("Monto", calcularMonto("Avanzado", participante3));
        participante3.put("Inscripcion", avanzado.size());
    }

    public static void mostrarInscriptos(List<Map<String, Object>> inscripciones) {
        for (Map<String, Object> participante : inscripciones) {
            for (Map.Entry<String, Object> entry : participante.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
            System.out.println("--------------------");
        }
    }

    public static void desinscribirParticipante(List<Map<String, Object>> inscripciones, Map<String, Object> participante) {
        inscripciones.remove(participante);
    }

    public static int calcularMontoTotal(List<Map<String, Object>> inscripciones, String categoria) {
        int total = 0;
        for (Map<String, Object> participante : inscripciones) {
            total += (int) participante.get("Monto");
        }
        return total;
    }

    public static int calcularMonto(String categoria, Map<String, Object> participante) {
        Integer edad = (Integer) participante.get("Edad");
        switch (categoria) {
            case "Chico":
                return edad < 18 ? 1300 : 1500;
            case "Medio":
                return edad < 18 ? 2000 : 2300;
            case "Avanzado":
                return edad >= 18 ? 2800 : -1;
            default:
                return -1;
        }
    }
}
