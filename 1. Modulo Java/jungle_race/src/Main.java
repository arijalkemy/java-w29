import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public enum CategoryType {
        chico, medio, avanzado
    }

    public static void initializeCategory(Map<String, Object> category, CategoryType name) {
        switch (name) {
            case chico:
                category.put("id", 1);
                category.put("description", "2 km por selva y arroyos.");
                break;
            case medio:
                category.put("id", 2);
                category.put("description", "5 km por selva, arroyos y barro.");
                break;
            case avanzado:
                category.put("id", 3);
                category.put("description", "10 km por selva, arroyos, barro y escalada en piedra.");
                break;
        }
        category.put("name", name);
    }

    public static void initializeParticipant(
            Map<String, Object> participant,
            int id,
            int dni,
            String firstName,
            String lastName,
            int age,
            String cellPhone,
            String emergencyNumber,
            String bloodGroup
    ) {
        if (dni <= 0) throw new IllegalArgumentException("Invalid DNI");
        if (age < 0) throw new IllegalArgumentException("Invalid age");

        participant.put("id", id);
        participant.put("dni", dni);
        participant.put("firstName", firstName);
        participant.put("lastName", lastName);
        participant.put("age", age);
        participant.put("cellPhone", cellPhone);
        participant.put("emergencyNumber", emergencyNumber);
        participant.put("bloodGroup", bloodGroup);
    }

    public static void initializeInscriptions(Map<CategoryType, Set<Map<String, Object>>> inscriptions) {
        inscriptions.put(CategoryType.chico, new HashSet<>());
        inscriptions.put(CategoryType.medio, new HashSet<>());
        inscriptions.put(CategoryType.avanzado, new HashSet<>());
    }

    public static int registerAParticipant(
            Map<CategoryType, Set<Map<String, Object>>> inscriptions,
            int lastInscriptionNumber,
            CategoryType category,
            Map<String, Object> participant
    ) {
        if (!participantAlreadyRegistered(participant, inscriptions)) {
            int nextInscriptionNumber = lastInscriptionNumber + 1;
            Map<String, Object> newInscription = new HashMap<>();
            newInscription.put("id", nextInscriptionNumber);
            newInscription.put("category", category);
            newInscription.put("participant", participant);
            newInscription.put("price", getPrice(category, (int) participant.get("age")));
            inscriptions.get(category).add(newInscription);

            return nextInscriptionNumber;
        }

        return lastInscriptionNumber;
    }

    public static void removeInscription(
            Map<String, Object> participant,
            CategoryType category,
            Map<CategoryType, Set<Map<String, Object>>> inscriptions
    ) {
        Set<Map<String, Object>> categoryInscriptions = inscriptions.get(category);

        categoryInscriptions.removeIf(inscription -> {
            Map<String, Object> inscriptionParticipant = (Map<String, Object>) inscription.get("participant");
            return (int) inscriptionParticipant.get("dni") == (int) participant.get("dni");
        });
    }

    public static boolean participantAlreadyRegistered(
            Map<String, Object> participant,
            Map<CategoryType, Set<Map<String, Object>>> inscriptions
    ) {
        int participantDNI = (int) participant.get("dni");
        for (CategoryType category : inscriptions.keySet()) {
            for (Map<String, Object> categoryInscription : inscriptions.get(category)) {
                Map<String, Object> currentParticipant = (Map<String, Object>) categoryInscription.get("participant");
                if ((int) currentParticipant.get("dni") == participantDNI) {
                    return true;
                }
            }
        }
        return false;
    }

    public static double getPrice(CategoryType category, int participantAge) {
        return (participantAge < 18)
                ? getPriceUnderEighteen(category)
                : getPriceOverEighteen(category);
    }

    public static double getPriceUnderEighteen(CategoryType category) {
        switch (category) {
            case chico:
                return 1300;
            case medio:
                return 2000;
            default:
                throw new IllegalArgumentException("Inscription to 'avanzado' not allowed for minors.");
        }
    }

    public static double getPriceOverEighteen(CategoryType category) {
        switch (category) {
            case chico:
                return 1500;
            case medio:
                return 2300;
            case avanzado:
                return 2800;
        }
        return 0;
    }

    public static void printInscriptors(
            CategoryType category,
            Map<CategoryType, Set<Map<String, Object>>> inscriptions
    ) {
        Set<Map<String, Object>> categoryInscriptions = inscriptions.get(category);

        System.out.println("----- Inscriptos del circuito " + category + ":");

        if (categoryInscriptions == null || categoryInscriptions.isEmpty()) {
            System.out.println("No hay inscriptos en este circuito.");
        } else {
            for (Map<String, Object> inscription : categoryInscriptions) {
                int inscriptionId = (int) inscription.get("id");
                Map<String, Object> inscriptionParticipant = (Map<String, Object>) inscription.get("participant");
                String participantFullName = (String) inscriptionParticipant.get("lastName") + ", " + inscriptionParticipant.get("firstName");
                System.out.println(inscriptionId + " - " + participantFullName + ".");
            }
        }

        System.out.println("------\n");
    }

    public static double getCategoryCollectedMoney(
            CategoryType category,
            Map<CategoryType, Set<Map<String, Object>>> inscriptions
    ) {
        double collectedMoney = 0;
        for (Map<String, Object> inscription : inscriptions.get(category)) {
            collectedMoney += (double) inscription.get("price");
        }
        return collectedMoney;
    }

    public static double getTotalMoney(Map<CategoryType, Set<Map<String, Object>>> inscriptions) {
        double totalMoney = 0;
        for (CategoryType category : inscriptions.keySet()) {
            totalMoney += getCategoryCollectedMoney(category, inscriptions);
        }
        return totalMoney;
    }

    public static void main(String[] args) {
        // Categories
        Map<String, Object> circuitoChico = new HashMap<>();
        Map<String, Object> circuitoMedio = new HashMap<>();
        Map<String, Object> circuitoAvanzado = new HashMap<>();

        initializeCategory(circuitoChico, CategoryType.chico);
        initializeCategory(circuitoMedio, CategoryType.medio);
        initializeCategory(circuitoAvanzado, CategoryType.avanzado);

        // Participants
        Map<String, Object> fstParticipant = new HashMap<>();
        Map<String, Object> sndParticipant = new HashMap<>();
        Map<String, Object> trdParticipant = new HashMap<>();

        initializeParticipant(
                fstParticipant,
                1,
                12345678,
                "Primer",
                "Participante",
                21,
                "1",
                "2",
                "A+"
        );

        initializeParticipant(
                sndParticipant,
                2,
                23456789,
                "Segundo",
                "Participante",
                15,
                "3",
                "4",
                "O+"
        );

        initializeParticipant(
                trdParticipant,
                3,
                34567890,
                "Tercer",
                "Participante",
                40,
                "5",
                "6",
                "A-"
        );

        // Inscriptions
        int lastInscriptionNumber = 0;
        Map<CategoryType, Set<Map<String, Object>>> raceInscriptions = new HashMap<>();

        initializeInscriptions(raceInscriptions);

        lastInscriptionNumber = registerAParticipant(
                raceInscriptions,
                lastInscriptionNumber,
                CategoryType.chico,
                fstParticipant
        );

        lastInscriptionNumber = registerAParticipant(
                raceInscriptions,
                lastInscriptionNumber,
                CategoryType.medio,
                sndParticipant
        );

        lastInscriptionNumber = registerAParticipant(
                raceInscriptions,
                lastInscriptionNumber,
                CategoryType.avanzado,
                trdParticipant
        );

        // Prints
        printInscriptors(CategoryType.chico, raceInscriptions);
        printInscriptors(CategoryType.medio, raceInscriptions);
        printInscriptors(CategoryType.avanzado, raceInscriptions);

        // Participant removal
        removeInscription(trdParticipant, CategoryType.avanzado, raceInscriptions);
        printInscriptors(CategoryType.avanzado, raceInscriptions);

        // Total money
        System.out.println("Circuito chico collected money: " + getCategoryCollectedMoney(CategoryType.chico, raceInscriptions));
        System.out.println("Circuito medio collected money: " + getCategoryCollectedMoney(CategoryType.medio, raceInscriptions));
        System.out.println("Circuito avanzado collected money: " + getCategoryCollectedMoney(CategoryType.avanzado, raceInscriptions));

        System.out.println("Race collected money: " + getTotalMoney(raceInscriptions));
    }
}
