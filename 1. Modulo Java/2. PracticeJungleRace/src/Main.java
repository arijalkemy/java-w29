import javax.management.ObjectName;
import java.util.*;

public class Main {
    /**
     * Constants
     */
    private static final int ID_NAME_CATEGORY = 0;
    private static final int ID_DESCRIPTION_CATEGORY = 1;
    private static final int ID_NUMBER_RUNNER = 0;
    private static final int ID_DNI_RUNNER = 1;
    private static final int ID_NAME_RUNNER = 2;
    private static final int ID_LASTNAME_RUNNER = 3;
    private static final int ID_AGE_RUNNER = 4;
    private static final int ID_PHONE_RUNNER = 5;
    private static final int ID_EMERGENCY_RUNNER = 6;
    private static final int ID_BLOOD_RUNNER = 7;
    private static final int ID_CATEGORY_INSCRIPTION = 0;
    private static final int ID_RUNNER_INSCRIPTION = 1;
    private static final int ID_AMOUNT_INSCRIPTION = 2;

    /**
     * Variables
     */
    private static double totalAmount = 0.0;
    private static double amount;

    public static void main(String[] args) {

        // a)
        // Category related index as id, key as name and value as description
        Map<Integer, List<Object>> categories = new HashMap<>();
        categories.put((Integer) 1, new ArrayList<>(List.of("Circuito chico", "2 km por selva y arrollos")));
        categories.put((Integer) 2, new ArrayList<>(List.of("Circuito medio", "5 km por selva, arroyos y barro")));
        categories.put((Integer) 3, new ArrayList<>(List.of("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra")));

        // b)
        // Runner information
        // number of runner, dni, name, lastname, age, phone number, emergency number, blood group
        List<List<Object>> runners = new ArrayList<>();
        runners.add(new ArrayList<>(List.of(123, "123456", "Nombre1", "Apellido1", 12, "1231456", "987654", "O")));
        runners.add(new ArrayList<>(List.of(456, "123456", "Nombre2", "Apellido2", 18, "1231456", "987654", "A")));
        runners.add(new ArrayList<>(List.of(789, "123456", "Nombre3", "Apellido3", 17, "1231456", "987654", "B")));
        runners.add(new ArrayList<>(List.of(192, "123456", "Nombre4", "Apellido4", 25, "1231456", "987654", "O")));
        runners.add(new ArrayList<>(List.of(546, "123456", "Nombre5", "Apellido5", 31, "1231456", "987654", "A")));

        // c)
        // Inscription information
        Map<Integer, List<Object>> inscriptions = new HashMap<>();
        inscriptions.put((Integer) 1, new ArrayList<>(List.of(categories.get((Integer) 1), runners.get(0), getAmount(1, runners.get(0)))));
        inscriptions.put((Integer) 2, new ArrayList<>(List.of(categories.get((Integer) 1), runners.get(1), getAmount(1, runners.get(1)))));
        inscriptions.put((Integer) 3, new ArrayList<>(List.of(categories.get((Integer) 2), runners.get(2), getAmount(2, runners.get(2)))));
        inscriptions.put((Integer) 4, new ArrayList<>(List.of(categories.get((Integer) 2), runners.get(3), getAmount(2, runners.get(3)))));
        inscriptions.put((Integer) 5, new ArrayList<>(List.of(categories.get((Integer) 3), runners.get(4), getAmount(3, runners.get(4)))));

        // d)
        System.out.println("=========== Inscritos por categoría ===========");
        for(int i = 1; i < 4; i++) {
            System.out.println("=========== Categoría: " + categories.get((Integer) i).get(ID_NAME_CATEGORY) + " ===========");
            System.out.println("=========== " + categories.get((Integer) i).get(ID_DESCRIPTION_CATEGORY) + " ===========");
            printInscriptionByCategory(categories.get((Integer) i), inscriptions);
        }

        // e)
        System.out.println("=========== Inscritos actualizados ===========");
        inscriptions.remove((Integer) 2);
        System.out.println("=========== Categoría: " + categories.get((Integer) 1).get(ID_NAME_CATEGORY) + " ===========");
        printInscriptionByCategory(categories.get((Integer) 1), inscriptions);

        // f)
        System.out.println("=========== Dinero recaudado ===========");
        for(int i = 1; i < 4; i++) {
            System.out.println("=========== " + categories.get((Integer) i).get(ID_NAME_CATEGORY) + " ===========");
            amount = getAmount(categories.get((Integer) i), inscriptions);
            totalAmount += amount;
            System.out.println(" ** " + amount);
        }
        System.out.println("=========== TOTAL RECAUDADO =========== " );
        System.out.println(" ** " + totalAmount);
    }

    /**
     * Get amount based on the category and runner age
     * @param category type
     * @param runner information
     * @return amount of race
     */
    private static double getAmount(int category, List<Object> runner) {
        double amount = 0.0;

        switch (category) {
            case 1 -> {
                if ((int) runner.get(4) < 18)
                    amount = 1300;
                else
                    amount = 1500;
            }
            case 2 -> {
                if ((int) runner.get(4) < 18)
                    amount = 2000;
                else
                    amount = 2300;
            }
            case 3 -> amount = 2800;
        }

        return amount;
    }

    /**
     * Print runners information by selected category
     * @param category selected category
     * @param inscriptions List of inscription
     */
    private static void printInscriptionByCategory(List<Object> category, Map<Integer, List<Object>> inscriptions) {
        for (Map.Entry<Integer, List<Object>> inscription : inscriptions.entrySet()) {
            List<Object> inscriptionCategory = (List<Object>) inscription.getValue().get(ID_CATEGORY_INSCRIPTION);
            if(inscriptionCategory.get(ID_NAME_CATEGORY).equals(category.get(ID_NAME_CATEGORY))) {
                System.out.println("---------------------");
                System.out.println("Número de partipante: " + ((List<Object>) inscription.getValue().get(ID_RUNNER_INSCRIPTION)).get(ID_NUMBER_RUNNER));
                System.out.println("DNI: " + ((List<Object>) inscription.getValue().get(ID_RUNNER_INSCRIPTION)).get(ID_DNI_RUNNER));
                System.out.println("Nombre: " + ((List<Object>) inscription.getValue().get(ID_RUNNER_INSCRIPTION)).get(ID_NAME_RUNNER));
                System.out.println("Apellido: " + ((List<Object>) inscription.getValue().get(ID_RUNNER_INSCRIPTION)).get(ID_LASTNAME_RUNNER));
                System.out.println("Edad: " + ((List<Object>) inscription.getValue().get(ID_RUNNER_INSCRIPTION)).get(ID_AGE_RUNNER));
                System.out.println("Teléfono: " + ((List<Object>) inscription.getValue().get(ID_RUNNER_INSCRIPTION)).get(ID_PHONE_RUNNER));
                System.out.println("Número de emergencia: " + ((List<Object>) inscription.getValue().get(ID_RUNNER_INSCRIPTION)).get(ID_EMERGENCY_RUNNER));
                System.out.println("Grupo sanguíneo: " + ((List<Object>) inscription.getValue().get(ID_RUNNER_INSCRIPTION)).get(ID_BLOOD_RUNNER));
                System.out.println("Número de inscripción: " + inscription.getKey());
                System.out.println("Monto de inscripción: " + inscription.getValue().get(ID_AMOUNT_INSCRIPTION));
                System.out.println("---------------------\n");

            }
        }
    }

    /**
     * Get total amount by category selected
     * @param category selected
     * @param inscriptions list
     * @return total amount
     */
    private static double getAmount(List<Object> category, Map<Integer, List<Object>> inscriptions) {
        double total = 0;
        for (Map.Entry<Integer, List<Object>> inscription : inscriptions.entrySet()) {
            List<Object> inscriptionCategory = (List<Object>) inscription.getValue().get(ID_CATEGORY_INSCRIPTION);
            if (inscriptionCategory.get(ID_NAME_CATEGORY).equals(category.get(ID_NAME_CATEGORY))) {
                total += (Double) inscription.getValue().get(ID_AMOUNT_INSCRIPTION);
            }
        }

        return total;
    }
}