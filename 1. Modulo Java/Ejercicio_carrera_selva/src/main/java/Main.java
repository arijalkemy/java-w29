import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        ArrayList<HashMap<String, Object>> categories = new ArrayList<>();

        HashMap<String, Object> smallCircuit = new HashMap<>();
        smallCircuit.put("id", 1);
        smallCircuit.put("name", "Circuito chico");
        smallCircuit.put("description", "Circuito 2 km por selva y arroyos");

        HashMap<String, Object> mediumCircuit = new HashMap<>();
        mediumCircuit.put("id", 2);
        mediumCircuit.put("name", "Circuito medio");
        mediumCircuit.put("description", "Circuito 5 km por selva, arroyos y barro");

        HashMap<String, Object> largeCircuit = new HashMap<>();
        largeCircuit.put("id", 3);
        largeCircuit.put("name", "Circuito avanzado");
        largeCircuit.put("description", "Circuito 10 km por selva, arroyos, barro y escalada en piedra");

        categories.add(smallCircuit);
        categories.add(mediumCircuit);
        categories.add(largeCircuit);

        ArrayList<HashMap<String, Object>> participants = new ArrayList<>();

        HashMap<String, Object> participant1 = createParticipant(
                "123456",
                "123456789",
                "Nicolas",
                "Serena",
                29,
                99123456,
                99234567,
                "A+"
        );

        HashMap<String, Object> participant2 = createParticipant(
                "123457",
                "123456789",
                "Jorge",
                "Serena",
                29,
                99123456,
                99234567,
                "A+"
        );

        HashMap<String, Object> participant3 = createParticipant(
                "123458",
                "123456789",
                "Ana",
                "Serena",
                9,
                99123456,
                99234567,
                "A+"
        );
        HashMap<String, Object> participant4 = createParticipant(
                "123459",
                "123456789",
                "Maxi",
                "Rodriguez",
                29,
                99123456,
                99234567,
                "A+"
        );
        participants.add(participant1);
        participants.add(participant2);
        participants.add(participant3);
        participants.add(participant4);


        ArrayList<HashMap<String, Object>> inscriptions = new ArrayList<>();
        try {

            inscriptions.add(
                    inscription(
                            participant1,
                            smallCircuit
                    )
            );
            inscriptions.add(
                    inscription(
                            participant4,
                            smallCircuit
                    )
            );
            inscriptions.add(
                    inscription(
                            participant2,
                            largeCircuit
                    )
            );
            inscriptions.add(
                    inscription(
                            participant3,
                            mediumCircuit
                    )
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        showParticipantsForCategory(smallCircuit, inscriptions, participants);
        inscriptions.removeFirst();
        System.out.println("==== Se desinscribe participante ====");
        showParticipantsForCategory(smallCircuit, inscriptions, participants);
        showCollectedAmountsByCategory(categories, inscriptions);
    }

    private static void showParticipantsForCategory(HashMap<String, Object> smallCircuit, ArrayList<HashMap<String, Object>> inscriptions, ArrayList<HashMap<String, Object>> participants) {
        System.out.println("==== Participantes para la categoria " + smallCircuit.get("name") + " ====");
        int insNumber = 0;
        for (HashMap<String, Object> ins : inscriptions) {
            if ((int) ins.get("categoryId") == (int) smallCircuit.get("id")) {
                String participantID = ins.get("participantId").toString();
                HashMap<String, Object> foundParticipant = getParticipantByID(participants, participantID);
                System.out.println("Nº Inscripción: " + insNumber
                        + " - " + foundParticipant.get("name") + " " + foundParticipant.get("surname")
                        + " | Edad: " + foundParticipant.get("age")
                        + " | Monto abonado: $" + ins.get("amount"));
            }
            insNumber += 1;
        }
        System.out.println();
    }

    private static HashMap<String, Object> createParticipant(
            String id,
            String dni,
            String name,
            String surname,
            int age,
            int cellphone,
            int emergencyContact,
            String bloodGroup
    ) {
        HashMap<String, Object> participant1 = new HashMap<>();
        participant1.put("id", id);
        participant1.put("dni", dni);
        participant1.put("name", name);
        participant1.put("surname", surname);
        participant1.put("age", age);
        participant1.put("cellphone", cellphone);
        participant1.put("emergencyContact", emergencyContact);
        participant1.put("bloodGroup", bloodGroup);
        return participant1;
    }

    private static HashMap<String, Object> inscription(Map<String, Object> participant, Map<String, Object> category) throws Exception {

        HashMap<String, Object> inscription = new HashMap<>();
        int age = (int) participant.get("age");
        int categoryId = (int) category.get("id");
        int amount = 0;
        boolean isAdult = age > 18;

        if (isAdult) {
            switch (categoryId) {
                case 1:
                    amount += 1500;
                    break;
                case 2:
                    amount += 2300;
                    break;
                default:
                    amount += 2800;
                    break;
            }
        } else {
            switch (categoryId) {
                case 1:
                    amount += 1300;
                    break;
                case 2:
                    amount += 2000;
                    break;
                default:
                    throw new Exception("Menores de edad no pueden participar en esta categoría");
            }
        }

        inscription.put("participantId", participant.get("id").toString());
        inscription.put("categoryId", categoryId);
        inscription.put("amount", amount);
        return inscription;
    }

    private static HashMap<String, Object> getParticipantByID(ArrayList<HashMap<String, Object>> participants, String id) {
        for (HashMap<String, Object> p : participants) {
            if (p.get("id").toString().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public static void showCollectedAmountsByCategory(
            ArrayList<HashMap<String, Object>> categories,
            ArrayList<HashMap<String, Object>> inscriptions
    ) {

        HashMap<Integer, Integer> collectedMap = new HashMap<>();

        for (HashMap<String, Object> ins : inscriptions) {
            int catId = (int) ins.get("categoryId");
            int amount = (int) ins.get("amount");
            collectedMap.put(catId, collectedMap.getOrDefault(catId, 0) + amount);
        }

        System.out.println("===== Recaudado por categoria =====");
        int globalTotal = 0;

        for (HashMap<String, Object> cat : categories) {
            int categoryId = (int) cat.get("id");
            String categoryName = cat.get("name").toString();
            int collectedAmount = collectedMap.getOrDefault(categoryId, 0);
            globalTotal += collectedAmount;

            System.out.println("* " + categoryName + " (ID=" + categoryId + "): $" + collectedAmount);
        }
        System.out.println("Total recaudado: $" + globalTotal);
    }
}
