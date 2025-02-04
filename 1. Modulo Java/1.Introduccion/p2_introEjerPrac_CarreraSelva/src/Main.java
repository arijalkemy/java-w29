import java.util.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Map<String, Object>> participants = new ArrayList<>();
    private static final List<Map<String, Object>> categories = new ArrayList<>();
    private static final List<Map<String, Object>> registrations = new ArrayList<>();

    public static void main(String[] args) {

        boolean exit = false;

        Map<String, Object> category1 = new HashMap<>();
        Map<String, Object> category2 = new HashMap<>();
        Map<String, Object> category3 = new HashMap<>();

        category1.put("id", 1);
        category1.put("name", "Circuito chico");
        category1.put("description", "2 km por selva y arroyos.");

        category2.put("id", 2);
        category2.put("name", "Circuito medio");
        category2.put("description", "5 km por selva, arroyos y barro.");

        category3.put("id", 3);
        category3.put("name", "Circuito avanzado");
        category3.put("description", "10 km por selva, arroyos, barro y escalada en piedra.");

        categories.add(category1);
        categories.add(category2);
        categories.add(category3);

        while (!exit) {
            System.out.println("****** Bienvenido al evento 'Carrera de la Selva' ******");
            System.out.println("Por favor, elija una opción:");
            System.out.println("1. Crear participante");
            System.out.println("2. Inscribir participante");
            System.out.println("3. Desinscribir participante");
            System.out.println("4. Ver participantes inscritos");
            System.out.println("5. Ver ingresos del evento");
            System.out.println("0. Salir");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createParticipant();
                    break;
                case 2:
                    registerParticipant();
                    break;
                case 3:
                    unregisterParticipant();
                    break;
                case 4:
                    viewRegisteredParticipants();
                    break;
                case 5:
                    // viewEventRevenues();
                    break;
                case 0:
                    System.out.println("Saliendo de la aplicación...");
                    exit = true;
                    break;
                default:
                    System.out.println("Opcion no valida.");
                    break;
            }
        }

    }

    private static void createParticipant() {
        Map<String, Object> newParticipant = new HashMap<>();

        System.out.println("****** FORMULARIO CREACIÓN PARTICIPANTE ******");
        System.out.println("Ingresa el DNI del participante: ");
        String dni = scanner.nextLine();

        System.out.println("Ingresa el nombre del participante: ");
        String name = scanner.nextLine();

        System.out.println("Ingresa el teléfono del participante: ");
        String phone = scanner.nextLine();

        System.out.println("Ingresa la edad del participante: ");
        String age = scanner.nextLine();

        newParticipant.put("dni", dni);
        newParticipant.put("name", name);
        newParticipant.put("phone", phone);
        newParticipant.put("age", age);

        participants.add(newParticipant);

        System.out.println("****** Participante creado con éxito ******");
    }

    private static void registerParticipant() {

        double amount = 0;
        int participantAge;
        int selectedCategoryOption;
        int selectedParticipantOption;
        Map<String, Object> selectedParticipant;
        Map<String, Object> newRegistration = new HashMap<>();
        Random random = new Random();

        System.out.println("Seleccione una categoria:");
        for (int i = 0; i < categories.size(); i++) {
            Map<String, Object> category = categories.get(i);
            Object name = category.get("name");
            System.out.println(i + 1 + ". " + name);
        }

        selectedCategoryOption = scanner.nextInt();

        System.out.println("Buscando participantes en el sistema...");

        if (participants.isEmpty()) {
            System.out.println("No se ha encontrado ningún participante en el sistema.");
            return;
        }

        System.out.println("Seleccione un participante:");
        for (int i = 0; i < participants.size(); i++) {
            Map<String, Object> participant = participants.get(i);
            Object name = participant.get("name");
            System.out.println(i + 1 + ". " + name);
        }

        selectedParticipantOption = scanner.nextInt();
        selectedParticipant = participants.get(selectedParticipantOption - 1);


        participantAge = Integer.parseInt(selectedParticipant.get("age").toString());

        switch (selectedCategoryOption) {
            case 1:
                if (participantAge < 18) {
                    amount = 1300;
                } else {
                    amount = 1500;
                }
                break;
            case 2:
                if (participantAge < 18) {
                    amount = 2000;
                } else {
                    amount = 2300;
                }
                break;
            case 3:
                if (participantAge < 18) {
                    System.out.println("No puede inscribirse en esta categoria.");
                    return;
                } else {
                    amount = 2800;
                }
                break;
        }

        newRegistration.put("id", random.nextInt(1000));
        newRegistration.put("participant_id", selectedParticipant.get("dni"));
        newRegistration.put("category_id", selectedCategoryOption);
        newRegistration.put("amount", amount);

        registrations.add(newRegistration);
    }

    private static void unregisterParticipant() {
        Map<String, Object> registrationToRemove = new HashMap<>();
        int option;

        if (registrations.isEmpty()) {
            System.out.println("No se ha encontrado ninguna inscripción en el sistema.");
            return;
        }

        System.out.println("Seleccione un participante:");
        for (int i = 0; i < registrations.size(); i++) {
            Map<String, Object> participant = registrations.get(i);
            Object name = participant.get("name");
            System.out.println(i + 1 + ". " + name);
        }

        option = scanner.nextInt();
        registrationToRemove = participants.get(option - 1);
        System.out.println(registrationToRemove);
        // participants.remove(option - 1);
    }

    private static void viewRegisteredParticipants() {
        for (Map<String, Object> registration : registrations) {
            System.out.println(registration);
        }
    }
}