import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // a. Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos.
        List<Map<String, String>> categories = List.of(
            new HashMap<>(Map.of("nombre", "Circuito chico", "descripcion", "2 km por selva y arroyos.")),
            new HashMap<>(Map.of("nombre", "Circuito mediano", "descripcion", "5 km por selva, arroyos y barro.")),
            new HashMap<>(Map.of("nombre", "Circuito avanzado", "descripcion", "10 km por selva, arroyos, barro y escalada en piedra."))
        );
        List<Map<String, String>> participants = List.of(
                new HashMap<>(Map.of("dni", "41318443", "nombre", "Matias", "apellido", "Daneri", "edad", "23", "celular", "1122766971", "emergencia", "911", "grupo","0+")),
                new HashMap<>(Map.of("dni", "21980074", "nombre", "Mariela", "apellido", "Allegri", "edad", "18", "celular", "1159628594", "emergencia", "911", "grupo","0+")),
                new HashMap<>(Map.of("dni", "21493319", "nombre", "Diego", "apellido", "Pombo", "edad", "27", "celular", "1123546798", "emergencia", "911", "grupo","A-")),
                new HashMap<>(Map.of("dni", "46026532", "nombre", "Sofia", "apellido", "Dizeo", "edad", "36", "celular", "1198786543", "emergencia", "911", "grupo","A+"))
        );

        // b & c. Inscribir a los participantes en distintas categorias.
        Map<Integer, Integer> inscriptions = new HashMap<>();   // participanteId: categoriaId
        inscriptions.put(0, 0);
        inscriptions.put(1, 1);
        inscriptions.put(2, 2);
        inscriptions.put(3, 2);

        // d. Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
        int categoryNumber = 2;
        for (Integer pId : inscriptions.keySet()) {
            if (inscriptions.get(pId) == categoryNumber) {
                System.out.println("Participant{id: " + pId + ", nombre: " + participants.get(pId).get("nombre") + "}");
            }
        }

        // e. Desinscribir a un participante.
        Integer participantId = 2;

        int categoryEnrolled = inscriptions.get(participantId);
        inscriptions.remove(participantId);

        for (Integer pId : inscriptions.keySet()) {
            if (inscriptions.get(pId) == categoryEnrolled) {
                System.out.println("Participant{ " + pId + "} " + participants.get(pId).get("nombre"));
            }
        }

        // f. Calcular el monto total recaudado por cada categoría y el total de toda la carrera incluyendo todas las categorías.
        int[] prices = new int[3];
        for (Integer pId : inscriptions.keySet()) {
            categoryEnrolled = inscriptions.get(pId);

            Integer pAge = Integer.parseInt(participants.get(participantId).get("edad"));
            switch (categoryEnrolled) {
                case 0:
                    prices[categoryEnrolled] += pAge < 18 ? 1300 : 1500;
                    break;
                case 1:
                    prices[categoryEnrolled] += pAge < 18 ? 2000 : 2300;
                    break;
                case 2:
                    prices[categoryEnrolled] += 2800;
                    break;
            }
        }

        for (int categoryIndex = 0; categoryIndex < prices.length; categoryIndex++) {
            System.out.println("Category " + categoryIndex + ": " + prices[categoryIndex]);
        }

    }

}
