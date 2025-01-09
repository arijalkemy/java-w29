
import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // a. Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos.
        List<String> c1 = new ArrayList<>();
        c1.add("1");
        c1.add("Circuito chico");
        c1.add("2 km de selva y arroyos");

        List<String> c2 = new ArrayList<>();
        c2.add("2");
        c2.add("Circuito mediano");
        c2.add("5 km de selva, arroyos y barro");

        List<String> c3 = new ArrayList<>();
        c3.add("3");
        c3.add("Circuito avanzado");
        c3.add("10 km por selva, arroyos, barro y escalada en piedra");


        // b. Crear los participantes
        List<String> p1 = new ArrayList<>();
        p1.add("41318446");
        p1.add("John");
        p1.add("Doe");
        p1.add("41");
        p1.add("1127244291");
        p1.add("123");
        p1.add("O+");

        List<String> p2 = new ArrayList<>();
        p2.add("81239");
        p2.add("Lucas");
        p2.add("Alexis");
        p2.add("17");
        p2.add("1127244291");
        p2.add("321");
        p2.add("O-");

        List<String> p3 = new ArrayList<>();
        p3.add("1828391");
        p3.add("Hernan");
        p3.add("Almagro");
        p3.add("29");
        p3.add("123123");
        p3.add("3219192");
        p3.add("B+");

        List<String> p4 = new ArrayList<>();
        p4.add("1828391");
        p4.add("Agustin");
        p4.add("Deaquila");
        p4.add("49");
        p4.add("123123");
        p4.add("3219192");
        p4.add("B+");

        // participantId, List<Datos del participante>
        Map<Integer, List<String>> participantsById = new HashMap<>();

        // participantId, List<Datos de la categoria>
        Map<Integer, List<String>> categoriesByParticipantId = new HashMap<>();

        // b. Inscribir a los participantes en distintas categorias.
        participantsById.put(1, p1);
        participantsById.put(2, p2);
        participantsById.put(3, p3);
        participantsById.put(4, p3);

        // c. Inscribir a los participantes en distintas categorias
        categoriesByParticipantId.put(1, c1);
        categoriesByParticipantId.put(2, c2);
        categoriesByParticipantId.put(3, c3);
        categoriesByParticipantId.put(4, c3);

        // d. Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
        String categoryNumber = "2";
        for (Integer pId : participantsById.keySet()) {
            // ["id", "name", "desc"]
            List<String> c = categoriesByParticipantId.get(pId);
            if (c.get(0).equals(categoryNumber)) {
                System.out.println("Participant{ " + pId + "} " + participantsById.get(pId));
            }
        }

        // e. Desinscribir a un participante.
        Integer participantId = 2;
        categoryNumber = categoriesByParticipantId.get(participantId).get(0);

        participantsById.remove(participantId);
        categoriesByParticipantId.remove(participantId);
        for (Integer pId : participantsById.keySet()) {
            // ["id", "name", "desc"]
            List<String> c = categoriesByParticipantId.get(pId);
            if (c.get(0).equals(categoryNumber)) {
                System.out.println("Participant{ " + pId + "} " + participantsById.get(pId));
            }
        }

        // f. Calcular el monto total recaudado por cada categoría y el total de toda la carrera incluyendo todas las categorías.
        int[] prices = new int[3];
        for (Integer pId : participantsById.keySet()) {
            List<String> c = categoriesByParticipantId.get(pId);

            Integer pAge = Integer.parseInt(participantsById.get(pId).get(3));
            switch (c.get(0)) {
                case "1":
                    prices[Integer.parseInt(c.get(0)) - 1] += pAge < 18 ? 1300 : 1500;
                    break;
                case "2":
                    prices[Integer.parseInt(c.get(0)) - 1] += pAge < 18 ? 2000 : 2300;
                    break;
                case "3":
                    prices[Integer.parseInt(c.get(0)) - 1] += 2800;
                    break;
            }
        }

        for (int categoryIndex = 0; categoryIndex < prices.length; categoryIndex++) {
            System.out.println("Category " + categoryIndex + ": " + prices[categoryIndex]);
        }


    }

}
