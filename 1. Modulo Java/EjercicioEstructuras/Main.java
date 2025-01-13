import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;


public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();
    public static void createParticipantAndInscription(HashMap<String,Category> categorys, String categoryToAdd) {
        System.out.println("Ingrese nombre del participante:");
        String name = scanner.nextLine();
        System.out.println("Ingrese apellido del participante:");
        String surname = scanner.nextLine();
        System.out.println("Ingrese edad del participante:");
        int age = scanner.nextInt();
        scanner.nextLine(); // Limpiando el buffer del scanner
        System.out.println("Ingrese DNI del participante:");
        int dni = scanner.nextInt();
        scanner.nextLine(); // Limpiando el buffer del scanner
        System.out.println("Ingrese numero de telefono del participante:");
        int phone = scanner.nextInt();
        scanner.nextLine(); // Limpiando el buffer del scanner
        System.out.println("Ingrese numero de telefono de emergencia del participante:");
        int emergencyPhone = scanner.nextInt();
        scanner.nextLine(); // Limpiando el buffer del scanner
        System.out.println("Ingrese tipo de sangre del participante:");
        String bloodType = scanner.nextLine();

        Participant participant = new Participant(name, surname, age, dni, phone, emergencyPhone, bloodType);
        
        // Verificamos que el participante no se encuentra ya inscripto en alguna categoria
        for (Map.Entry<String, Category> cat : categorys.entrySet()){
            if (cat.getKey() != categoryToAdd) {
                Category catToVerify = cat.getValue();
                for (Inscription s : catToVerify.subscriptions){
                    if (s.participant.dni == participant.dni){
                        System.out.println("Este participante ya se encuentra inscripto en la categoría " + cat.getKey());
                        return;
                    }
                }
                
            }
        }

        // Creando la inscripcion
        int numberOfInscription = random.nextInt();
        Inscription inscription = new Inscription(numberOfInscription, categorys.get(categoryToAdd), participant);
        if (inscription.abono > 0){
            System.out.println("Inscripción creada con éxito!");        
        }else {
            System.out.println("No se pudo crear la inscripción. No cumple los requisitos de edad");
        }
    }
    public static void deleteInscription(Category category, int numberOfInscription){
        return;
    }
    public static void showInscriptionsPerCategory(Category category){
        for (Inscription subscription : category.subscriptions){
            System.out.println("Numero de inscripcion: " + subscription.number);
            System.out.println("Nombre: " + subscription.participant.name);
            System.out.println("Apellido: " + subscription.participant.surname);
            System.out.println("Edad: " + subscription.participant.age);
            System.out.println("DNI: " + subscription.participant.dni);
            System.out.println("Telefono: " + subscription.participant.phone);
            System.out.println("Telefono de emergencia: " + subscription.participant.emergencyPhone);
            System.out.println("Tipo de sangre: " + subscription.participant.bloodType);
            System.out.println("Abono: " + subscription.abono);
            System.out.println("-----------------------------------");
        }
        
        return;
    }

    public static void totalIncomePerCategory(Category category){
        return;
    }

    public static void createRandomInscriptions(int howMany){
        if (howMany < 3 ){
            howMany = 3;
        }

        for (int i = 0; i < howMany; i++){
            //Crear 3 inscreipciones una por cada categoria minimo
        }
    }
    public static void main(String[] args) {
        // Creating HashMap para las categorias
        HashMap<String, Category> categoryHashMap = new HashMap<String, Category>();
        // Añadiendo categorias al HashMap
        categoryHashMap.put("Circuito Chico", new Category(1, "Circuito Chico", "2 km por selva y arroyos."));
        categoryHashMap.put("Circuito Medio", new Category(2, "Circuito Medio", "5 km por selva, arroyos y barro."));
        categoryHashMap.put("Circuito Avanzado", new Category(3, "Circuito Avanzado", "10 km por selva, arroyos, barro y escalada en piedra."));

        //Inicio programa para carreras
        boolean runProgram = true;
        while (runProgram) {
            System.out.println("Menu de opciones");
            System.out.println("1. Mostrar Categorias");
            System.out.println("2. Crear Inscripcion");
            System.out.println("3. Eliminar Inscripcion");
            System.out.println("4. Mostrar Inscripciones por Categoria");
            System.out.println("5. Mostrar Ingresos por Categoria");
            System.out.println("6. Salir");
            System.out.println("Ingrese su opcion:");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiando el buffer del scanner
            switch (opcion) {
                case 1://Mostrar Categorias
                    System.out.println();
                    for (Map.Entry<String, Category> cat : categoryHashMap.entrySet()){
                        System.out.println( "Categoria " + String.valueOf(cat.getValue().id) + " " +"Nombre: " + cat.getValue().name + ", Descripcion: " + cat.getValue().description);
                    }
                    System.out.println();
                    break;
                case 2://Crear Inscripcion
                    System.out.println();
                    System.out.println("Ingrese el numero de la categoría a la que desea inscribirse:");
                    int categoryNumber = scanner.nextInt();
                    String categoryToAdd = "";
                    for (Map.Entry<String, Category> cat : categoryHashMap.entrySet()){
                        if (cat.getValue().id == categoryNumber){
                            categoryToAdd = cat.getKey();
                        }
                    }
                    createParticipantAndInscription(categoryHashMap, categoryToAdd);
                    break;
                case 3://Eliminar Inscripcion
                    System.out.println("Ingrese el numero de la categoría:");
                    int categoryToSearch = scanner.nextInt();
                    scanner.nextLine();
                    String catToSearchInscriptions = "";
                    for (Map.Entry<String, Category> cat : categoryHashMap.entrySet()){
                        if (cat.getValue().id == categoryToSearch){
                            catToSearchInscriptions = cat.getKey();
                        }
                    }
                    System.out.println("Ingrese el numero de la inscripcion a eliminar:");
                    int inscriptionToDelete = scanner.nextInt();
                    deleteInscription(categoryHashMap.get(catToSearchInscriptions), inscriptionToDelete);
                    break;
                case 4://Mostrar Inscripciones
                    System.out.println("Ingrese el numero de la categoría:");
                    int categoryToShow = scanner.nextInt();
                    scanner.nextLine();
                    String catToShowInscriptions = "";
                    for (Map.Entry<String, Category> cat : categoryHashMap.entrySet()){
                        if (cat.getValue().id == categoryToShow){
                            catToShowInscriptions = cat.getKey();
                        }
                    }
                    showInscriptionsPerCategory(categoryHashMap.get(catToShowInscriptions));
                    break;
                case 5://Mostrar Ingresos por Categoria
                    break;
                case 6://Salir
                    runProgram = false;
                default:
                    break;
            } 
        }
    }

}

