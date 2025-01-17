package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Circuitos
        Map<Integer, String> circuitos = new HashMap<>();
        circuitos.put(1, "Circuito chico: 2 km por selva y arroyos.");
        circuitos.put(2, "Circuito medio: 5 km por selva, arroyos y barro.");
        circuitos.put(3, "Circuito avanzado: 10 km por selva, arroyos, barro y escalada en piedra.");
        System.out.println("\n");

        //Monto
        Map<Integer, Integer> monto = new HashMap<>();
        monto.put(1, 0);
        monto.put(2, 0);
        monto.put(3, 0);

        //Participante
        ArrayList<String> participante = new ArrayList<>();
        participante.add("11114444");
        participante.add("daniel");
        participante.add("reynaga");
        participante.add("65");
        participante.add("12345678");
        participante.add("12345678");
        participante.add("RH+");

        ArrayList<String> participante2 = new ArrayList<>();
        participante2.add("11223344");
        participante2.add("gela");
        participante2.add("nn");
        participante2.add("22");
        participante2.add("12345678");
        participante2.add("12345678");
        participante2.add("RH+");

        //Lista de participantes inscriptos
        Map<Integer, ArrayList<ArrayList<String>>> inscripciones = new HashMap<>();
        inscripciones.put(1, new ArrayList<>());
        inscripciones.put(2, new ArrayList<>());
        inscripciones.put(3, new ArrayList<>());

        //Inscripcion de participantes
        inscribirParticipante(circuitos, participante, inscripciones, monto);
        inscribirParticipante(circuitos, participante2, inscripciones, monto);


        //Inscripcion por categoria
        mostrarInscriptosPorCategoria(inscripciones);

        //Desinscribir a un participante. Mostrar como queda la lista de inscriptos en la categoría donde se encontraba.
        desinscribirParticipante("11114444", inscripciones);

        //Calcular el monto total recaudado por cada categoría y el total de toda la carrera incluyendo todas las categorías.
        calcularMontoTotal(monto);


    }

    private static void calcularMontoTotal(Map<Integer, Integer> monto) {
        int montoTotal = 0;
        for (Map.Entry<Integer, Integer> entry : monto.entrySet()) {
            montoTotal += entry.getValue();
        }
        System.out.println("El monto total recaudado es: " + montoTotal);
        System.out.println("El monto total recaudado por categoría es: ");
        for (Map.Entry<Integer, Integer> entry : monto.entrySet()) {
            System.out.println("Categoría " + entry.getKey() + ": " + entry.getValue());
        }
    }

    private static void desinscribirParticipante(String idParticipante, Map<Integer, ArrayList<ArrayList<String>>> inscripciones) {
        final Integer[] keyAmostrar = {null};
        inscripciones.forEach((key, lista) -> {
            if(lista.removeIf(participante -> participante.getFirst().equals(idParticipante))){
                keyAmostrar[0] = key;
                return;
            };
        });

        System.out.println("El participante con ID " + idParticipante + " ha sido desinscrito correctamente.");
        System.out.println("la categoria "+ keyAmostrar[0] + " luego de la eliminacion: ");
        System.out.println(inscripciones.get(keyAmostrar[0]));
    }

    private static void inscribirParticipante(Map<Integer, String> circuitos, ArrayList<String> participante, Map<Integer, ArrayList<ArrayList<String>>> inscripciones, Map<Integer, Integer> monto) {
        System.out.println("Inscribir participante");
        System.out.println("Circuitos disponibles:");
        for (Map.Entry<Integer, String> entry : circuitos.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Ingrese el número de circuito al que desea inscribirse:");
        Scanner scanner = new Scanner(System.in);
        int numeroCircuito = scanner.nextInt();

        int edad = Integer.parseInt(participante.get(3));
        int montoInscripcion = 0;

        switch (numeroCircuito) {
            case 1 -> {
                montoInscripcion = edad < 18 ? 1300 : 1500;
                inscripciones.get(numeroCircuito).add(participante);
                System.out.println("El participante ha sido inscrito correctamente en el circuito " + circuitos.get(numeroCircuito) + "\n");
            }
            case 2 -> {
                montoInscripcion = edad < 18 ? 2000 : 2300;
                inscripciones.get(numeroCircuito).add(participante);
                System.out.println("El participante ha sido inscrito correctamente en el circuito " + circuitos.get(numeroCircuito));
            }
            case 3 -> {
                if (edad < 18) {
                    System.out.println("El participante no puede inscribirse en el Circuito avanzado ya que es menor de 18 años.");
                } else {
                    montoInscripcion = 2800;
                    inscripciones.get(numeroCircuito).add(participante);
                    System.out.println("El participante ha sido inscrito correctamente en el circuito " + circuitos.get(numeroCircuito));
                }
            }
            default -> System.out.println("El número de circuito ingresado no es válido.");
        }

        monto.put(numeroCircuito, monto.get(numeroCircuito) + montoInscripcion);
    }


    private static void mostrarInscriptosPorCategoria(Map<Integer, ArrayList<ArrayList<String>>> inscripciones){
        inscripciones.forEach((key, lista) -> {
            System.out.println("\nCategoria: " + key);
            lista.forEach((participante) -> {
                System.out.println("Participante: " + participante);
            });
        });
    }
}