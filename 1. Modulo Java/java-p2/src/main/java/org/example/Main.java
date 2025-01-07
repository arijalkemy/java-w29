package org.example;

import java.util.*;

public class Main {

    static final Integer CIRCUITO_MEDIO = 1;
    static final Integer CIRCUITO_AVANZADO = 2;
    static final Integer CIRCUITO_CHICO = 3;
    static Map<Integer, ArrayList<String>> competencia = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Map<Integer, Map<Integer, ArrayList<String>>> inscripciones = new HashMap<>();


        Main.competencia.put(CIRCUITO_MEDIO, new ArrayList<>(Arrays.asList("Circuito medio", "5 km por selva, arroyos y barro.")));
        Main.competencia.put(CIRCUITO_AVANZADO, new ArrayList<>(Arrays.asList("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.")));
        Main.competencia.put(CIRCUITO_CHICO, new ArrayList<>(Arrays.asList("Circuito chico", "2 km por selva y arroyos")));

        inscripciones.put(CIRCUITO_MEDIO, new HashMap<>());
        inscripciones.put(CIRCUITO_AVANZADO, new HashMap<>());
        inscripciones.put(CIRCUITO_CHICO, new HashMap<>());

        inscripciones.get(CIRCUITO_CHICO).put(1, new ArrayList<>(Arrays.asList("1300", "1", "Andres", "Largo", "14", "323123123", "3122223", "O+")));
        inscripciones.get(CIRCUITO_CHICO).put(4, new ArrayList<>(Arrays.asList("1300", "4", "Sergio", "Rozo", "13", "323123123", "3122223", "O+")));
        inscripciones.get(CIRCUITO_MEDIO).put(2, new ArrayList<>(Arrays.asList("2300", "2", "David", "Ahumada", "19", "32233", "2223123323", "O-")));
        inscripciones.get(CIRCUITO_AVANZADO).put(3, new ArrayList<>(Arrays.asList("2800", "3", "Alejandra", "Rozo", "22", "3222223123", "312311212323", "O+")));


        imprimirMapa(inscripciones);

        System.out.println("Eliminando participante");
        // Elimina el participante con id 4
        for (Map.Entry<Integer, Map<Integer, ArrayList<String>>> entry : inscripciones.entrySet()) {
            entry.getValue().remove(4);
        }

        imprimirMapa(inscripciones);

        // Inscribe nuevo participante
        ArrayList nuevoParticipante = new ArrayList(Arrays.asList("", "11", "Nuevo", "Participante", "28", "323123123", "3122223", "O+"));
        inscribirParticipante(inscripciones, nuevoParticipante, CIRCUITO_AVANZADO);
    }

    public static void imprimirMapa(Map<Integer, Map<Integer, ArrayList<String>>> mapa) {
        double monto = 0;
        for (Map.Entry<Integer, Map<Integer, ArrayList<String>>> entry : mapa.entrySet()) {
            System.out.println("\nCategoría: " + entry.getKey() + " " + competencia.get(entry.getKey()));
            System.out.println("Participantes: ");
            for (Map.Entry<Integer, ArrayList<String>> participante : entry.getValue().entrySet()) {
                System.out.println(participante.getKey() + " " + participante.getValue());
                monto = monto + Double.parseDouble(participante.getValue().getFirst());
            }
            System.out.println("Monto: " + monto);
        }
        System.out.println("----------------------");
    }

    public static void inscribirParticipante(Map<Integer, Map<Integer, ArrayList<String>>> mapa, ArrayList<String> participante, Integer categoria) throws Exception {
        System.out.println("Inscribiendo participante: " + participante.get(2) + " " + participante.get(3));
        if (categoria.equals(CIRCUITO_CHICO)) {
            if (Integer.parseInt(participante.get(4)) < 18) {
                participante.set(0, "1300");
            } else {
                participante.set(0, "1500");
            }
            mapa.get(CIRCUITO_CHICO).put(Integer.valueOf(participante.get(1)), participante);
        }

        if (categoria.equals(CIRCUITO_MEDIO)) {
            if (Integer.parseInt(participante.get(4)) < 18) {
                participante.set(0, "2000");
            } else {
                participante.set(0, "2300");
            }
            mapa.get(CIRCUITO_MEDIO).put(Integer.valueOf(participante.get(1)), participante);
        }

        if (categoria.equals(CIRCUITO_AVANZADO)) {
            if (Integer.parseInt(participante.get(4)) < 18) {
                throw new Exception("No puede participar porque es menor a 18 años");
            } else {
                participante.set(0, "2800");
                mapa.get(CIRCUITO_AVANZADO).put(Integer.valueOf(participante.get(1)), participante);
            }
        }

        imprimirMapa(mapa);
    }

}
