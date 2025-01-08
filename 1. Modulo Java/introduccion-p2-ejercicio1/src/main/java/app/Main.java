package app;

import java.util.*;

public class Main {

    final static int ID_CATEGORY_CIRCUITO_CHICO = 1;
    final static int ID_CATEGORY_CIRCUITO_MEDIO = 2;
    final static int ID_CATEGORY_CIRCUITO_AVANZADO = 3;

    public static void main(String[] args) {

        //A. Crear 3 categorias
        Map<Integer, Map<String, Object>> categories = initializeCategories();
        List<Map<String, Object>> inscriptions = new ArrayList<>();

        //Crear un participante e inscribirlo
        Map<String, Object> participant = createParticipant(
                101,
                "2320202",
                "Jorge",
                "Perez",
                25,
                "3145670909",
                "3056780901",
                "A+"
        );
        registerParticipant(categories, inscriptions, participant, ID_CATEGORY_CIRCUITO_CHICO);

        //Participantes Extra
        Map<String, Object> participant2 = createParticipant(
                102,
                "2320102",
                "Raul",
                "Jimenez",
                17,
                "3145270909",
                "3056780901",
                "O+"
        );
        registerParticipant(categories, inscriptions, participant2, ID_CATEGORY_CIRCUITO_CHICO);

        Map<String, Object> participant3 = createParticipant(
                103,
                "2320102",
                "Ximena",
                "Gonzales",
                20,
                "3125270909",
                "3026780901",
                "O+"
        );
        registerParticipant(categories, inscriptions, participant3, ID_CATEGORY_CIRCUITO_MEDIO);

        Map<String, Object> participant4 = createParticipant(
                104,
                "2320102",
                "Nicolas",
                "Gonzales",
                20,
                "3125270901",
                "3021780901",
                "A-"
        );
        registerParticipant(categories, inscriptions, participant4, ID_CATEGORY_CIRCUITO_AVANZADO);


        //Ver inscritos
        viewInscriptions(categories, inscriptions, ID_CATEGORY_CIRCUITO_CHICO);
        //viewInscriptions(categories, inscriptions, ID_CATEGORY_CIRCUITO_MEDIO);
        //viewInscriptions(categories, inscriptions, ID_CATEGORY_CIRCUITO_AVANZADO);

        //Eliminar un inscrito
        removeInscription(inscriptions,  101);
        viewInscriptions(categories, inscriptions, ID_CATEGORY_CIRCUITO_CHICO);


    }

    private static Map<Integer, Map<String, Object>> initializeCategories() {
        Map<Integer, Map<String, Object>> categories = new HashMap<>();

        categories.put(ID_CATEGORY_CIRCUITO_CHICO, Map.of(
                "name", "Circuito chico",
                "description", "2km por selva y arroyos",
                "feeMinor", 1300.0,
                "feeAdult", 1500.0
        ));

        categories.put(ID_CATEGORY_CIRCUITO_MEDIO, Map.of(
                "name", "Circuito medio",
                "description", "2km por selva y arroyos",
                "feeMinor", 2000.0,
                "feeAdult", 2300.0
        ));

        categories.put(ID_CATEGORY_CIRCUITO_AVANZADO, Map.of(
                "name", "Circuito avanzado",
                "description", "2km por selva y arroyos",
                "feeMinor", 0.0,
                "feeAdult", 2800.0
        ));

        return categories;
    }

    private static Map<String, Object> createParticipant(
            int id,
            String dni,
            String firstName,
            String lastName,
            int age,
            String phoneNumber,
            String emergencyContact,
            String bloodType
    ) {
        Map<String, Object> participant = new HashMap<>();
        participant.put("id", id);
        participant.put("dni", dni);
        participant.put("firstName", firstName);
        participant.put("lastName", lastName);
        participant.put("age", age);
        participant.put("phoneNumber", phoneNumber);
        participant.put("emergencyContact", emergencyContact);
        participant.put("bloodType", bloodType);

        return participant;
    }

    private static void registerParticipant(
            Map<Integer, Map<String, Object>> categories,
            List<Map<String, Object>> inscriptions,
            Map<String, Object> participant,
            int categoryId
            ) {

        Map<String, Object> category = categories.get(categoryId);
        double fee = (int) participant.get("age") < 18
                ? (double) category.get("feeMinor")
                : (double) category.get("feeAdult");

        int participantAge = (int) participant.get("age");
        if (categoryId == 3 && participantAge < 18) {
            System.out.println("No se puede inscribir menores en esta categoria");
            return;
        }

        Map<String, Object> inscription = new HashMap<>();
        inscription.put("id", inscriptions.size() + 1);
        inscription.put("participant", participant);
        inscription.put("category", category);
        inscription.put("fee", fee);

        inscriptions.add(inscription);

        System.out.println("Paricipante inscrito correctamente. Abono: " + fee);

    }

    private static void viewInscriptions(
            Map<Integer, Map<String, Object>> categories,
            List<Map<String, Object>> inscriptions,
            int categoryId
    ) {
        System.out.println("Inscritos en la categoria: " + categories.get(categoryId).get("name"));
        inscriptions.stream()
                .filter(inscription ->
                        inscription.get("category") == categories.get(categoryId))
                .forEach(System.out::println);
    }

    private static void removeInscription(List<Map<String, Object>> inscriptions, int participantId) {
        inscriptions.removeIf(inscription -> {
            Map<String, Object> participant = (Map<String, Object>) inscription.get("participant");
            return Integer.valueOf(participantId).equals((Integer) participant.get("id"));
        });
        System.out.printf("Participante con id %d eliminado\n", participantId);
    }
}
