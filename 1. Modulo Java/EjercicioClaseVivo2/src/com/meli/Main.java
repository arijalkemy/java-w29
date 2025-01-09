package com.meli;

import java.util.*;

public class Main {

    static String[] circuitoChico = {"1", "Circuito chico", "Descripcion"};
    static String[] circuitoMedio = {"2", "Circuito medio", "Descripcion"};
    static String[] circuitoAvanzado = {"3", "Circuito avanzado", "Descripcion"};

    static Map<Integer, Map<String, String>> incripciones = new HashMap<>();
    static Map<Integer, Map<String, String>> participantes = new HashMap<>();

    public static void main(String[] args) {
        Integer participante1Id = addParticipante("12345678", "Juan", "Pérez", "20", "555-1234", "555-5678", "O+");
        Integer participante2Id = addParticipante("87654321", "Maria", "Gómez", "17", "555-8765", "555-4321", "A-");
        Integer participante3Id = addParticipante("23456789", "Carlos", "López", "22", "555-2345", "555-6789", "B+");

        addIncripcion(participante1Id, circuitoChico[0]);
        addIncripcion(participante2Id, circuitoMedio[0]);
        addIncripcion(participante3Id, circuitoAvanzado[0]);
    }

    public static void addIncripcion(Integer participanteId, String circuito) {
        Integer abono = calculateAbono(participanteId, circuito);

        incripciones.put(
                incripciones.size() + 1,
                Map.of(
                        "participanteId", participanteId.toString(),
                        "circuito", circuito,
                        "abono", abono.toString()
                )
        );
    }

    public static Integer addParticipante(String dni, String nombre, String apellido, String edad, String celular, String numEmergencia, String gSanguineo) {
        Integer id = participantes.size() + 1;
        participantes.put(
                id,
                Map.of(
                        "dni", dni,
                        "nombre", nombre,
                        "apellido", apellido,
                        "edad", edad,
                        "celular", celular,
                        "numEmergencia", numEmergencia,
                        "gSanguineo", gSanguineo
                )
        );
        return id;
    }

    public static Integer calculateAbono(Integer participanteId, String circuito) {
        Integer abono = 0;
        Map<String, String> participante = participantes.get(participanteId);
        Integer edad = Integer.valueOf(participante.get("edad"));
        switch (circuito) {
            case "1":
                abono = edad >= 18 ? 1500 : 1300;
                break;
            case "2":
                abono = edad >= 18 ? 2300 : 2000;
                break;
            case "3":
                abono = edad >= 18 ? 2800 : -1;
                break;
        }

        return abono;
    }
}
