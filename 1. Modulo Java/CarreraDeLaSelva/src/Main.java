import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> circuitos = getStringArrayListHashMap();

        System.out.println("**** Categorias ****\n");
        for (Map.Entry<String, ArrayList<String>> entry : circuitos.entrySet()) {
            String nombreCategoria = "Descripción: " + entry.getValue().getFirst();
            System.out.println(entry.getKey() + ": " + nombreCategoria);
        }
        System.out.println("\n**** ----- ****\n");

        HashMap<Integer, ArrayList<String>> participantes = getIntegerArrayListHashMap();

        System.out.println("**** Participantes ****\n");
        for (Map.Entry<Integer, ArrayList<String>> entry : participantes.entrySet()) {
            String nombreParticipante = entry.getValue().get(1) + " " + entry.getValue().get(2) + " " + "Edad: " + entry.getValue().get(3);
            System.out.println(entry.getKey() + ": " + nombreParticipante);
        }
        System.out.println("\n**** ----- ****\n");

        Map<Integer, Object> inscripciones = new HashMap<>();

        int index = 1;
        for (Map.Entry<Integer, ArrayList<String>> participante : participantes.entrySet()) {
            ArrayList<String> participanteArray = participante.getValue();
            int edadParticipante = Integer.parseInt(participanteArray.get(3));
            String categoriaParticipante = participanteArray.get(7);
            ArrayList<String> detallesCircuito = circuitos.get(categoriaParticipante);
            int costoParticipante = 0;

            if (categoriaParticipante == "Circuito chico") {
                costoParticipante = (edadParticipante <= 18) ? Integer.parseInt(detallesCircuito.get(1)) : Integer.parseInt(detallesCircuito.get(2));
            } else if (categoriaParticipante == "Circuito medio") {
                costoParticipante = (edadParticipante <= 18) ? Integer.parseInt(detallesCircuito.get(1)) : Integer.parseInt(detallesCircuito.get(2));
            } else if (categoriaParticipante == "Circuito avanzado") {
                costoParticipante = (edadParticipante <= 18) ? Integer.parseInt(detallesCircuito.get(1)) : Integer.parseInt(detallesCircuito.get(2));
            } else {
                break;
            }

            ArrayList<Object> participantesInscripcion = new ArrayList<>(Arrays.asList(categoriaParticipante, participante, costoParticipante));
            inscripciones.put(index, participantesInscripcion);
            index++;
        }

        System.out.println(inscripciones);
    }

    private static HashMap<String, ArrayList<String>> getStringArrayListHashMap() {
        ArrayList<String> circuitoChico = new ArrayList<>(Arrays.asList("2 km por selva y arroyos.", "1300", "1500"));
        ArrayList<String> circuitoMedio = new ArrayList<>(Arrays.asList("5 km por selva, arroyos y barro.", "2000", "2300"));
        ArrayList<String> circuitoAvanzado = new ArrayList<>(Arrays.asList("10 km por selva, arroyos, barro y escalada en piedra.", "0", "2800"));

        HashMap<String, ArrayList<String>> circuitos = new HashMap<>();
        circuitos.put("Circuito chico", circuitoChico);
        circuitos.put("Circuito medio", circuitoMedio);
        circuitos.put("Circuito avanzado", circuitoAvanzado);
        return circuitos;
    }

    private static HashMap<Integer, ArrayList<String>> getIntegerArrayListHashMap() {
        HashMap<Integer, ArrayList<String>> participantes = new HashMap<>();
        ArrayList<String> participante1 = new ArrayList<>(Arrays.asList("1342134", "Jose", "Bernal", "17", "314189574", "431412341", "O+", "Circuito chico"));
        ArrayList<String> participante2 = new ArrayList<>(Arrays.asList("1234234", "Juan", "Bernal", "22", "314189574", "431412341", "A+", "Circuito medio"));
        ArrayList<String> participante3 = new ArrayList<>(Arrays.asList("1364365", "Fernanda", "Bernal", "28", "314189574", "431412341", "B+", "Circuito avanzado"));

        participantes.put(1, participante1);
        participantes.put(2, participante2);
        participantes.put(3, participante3);
        return participantes;
    }
}