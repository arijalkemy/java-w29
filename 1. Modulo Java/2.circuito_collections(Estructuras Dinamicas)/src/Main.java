
import java.util.*;

public class Main {
    static List<Map<String, Object>> inscriptions = new ArrayList<>();
    static Map<Integer,String[]> categories = new HashMap<>();



    public static void main(String[] args) {
        Map<String, Object> inscription = new HashMap<>();

        categories.put(1,new String[]{"short", "..."});
        categories.put(2,new String[]{"medium", "..."});
        categories.put(3,new String[]{"advanced", "..."});

        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        while(exit){
            System.out.println("\n1 para ingresar un nuevo Participante");
            System.out.println("2 para eliminar un Participante");
            System.out.println("3 para listar los participantes de cada categoria");
            System.out.println("4 para ver el total por categoria");
            System.out.println("5 para ver el total de la carrera");
            System.out.println("6 para Salir");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch(option){
                case 1:
                    inscription  = createInscription();
                    if (!inscription.isEmpty()) {
                        inscriptions.add(inscription);
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el DNI del Participante que desea eliminar: ");
                    String dni = scanner.nextLine();
                    deleteMember(dni);
                    break;
                case 3:
                    printInscriptions();
                    break;
                case 4:
                    getAmountByCategory();
                    break;
                case 5:
                    getAmountTotal();
                    break;
                case 6:
                    exit = false;
                    break;
                default:
                    exit = false;
                    break;
            }

        }



    }

    public static Map<String, Object> createInscription() {
        Map<String, Object> inscription = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int category;
        String name;
        int age;
        String dni;
        String number;
        String sanitizedNumber;
        double amount = 0;

        System.out.println("\nIngrese la categoria del Participante: \n 1 para Corta \n 2 para Media \n 3 para Larga");
        category = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el nombre del Participante: ");
        name = scanner.nextLine();
        System.out.print("Ingrese el dni del Participante: ");
        dni = scanner.nextLine();
        System.out.print("Ingrese la edad del Participante: ");
        age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el numero del Participante: ");
        number = scanner.nextLine();
        System.out.print("Ingrese su grupo Sanguineo: ");
        sanitizedNumber = scanner.nextLine();

        if (age >= 18) {
            switch (category) {
                case 1 -> {
                    amount = 1500;

                }
                case 2 -> {
                    amount = 2300;

                }
                case 3 -> {
                    amount = 2800;

                }

                default -> {
                    System.out.println("Categoria Invalida");
                    return inscription;
                }

            }
        } else {
            switch (category) {
                case 1 -> {
                    amount = 1300;

                }
                case 2 -> {
                    amount = 2000;

                }
                case 3 -> {
                    System.out.println("No se Permiten menores de 18 a esta Categoria");
                    return inscription;
                }
            }
        }

        if (!validateMember(dni,category)){
            return inscription;
        }

        inscription.put("inscription",inscriptions.size() + 1);
        inscription.put("dni",dni);
        inscription.put("amount",amount);
        inscription.put("category",categories.get(category));
        inscription.put("name",name);
        inscription.put("age",age);
        inscription.put("number",number);
        inscription.put("sanitizedNumber",sanitizedNumber);

        return inscription;
    }

    public static void printInscriptions() {
        for (int i = 1; i <= 3; i++) {
            System.out.printf("\n--- CATEGORIA %s ---\n",categories.get(i)[0]);
            for (Map<String, Object> inscription : inscriptions) {
                if (inscription.get("category").equals(categories.get(i))) {
                    System.out.println("Numero de Inscripcion: " + inscription.get("inscription"));
                    System.out.println("Nombre: " + inscription.get("name"));
                    System.out.println("Edad: " + inscription.get("age"));
                    System.out.println("Grupo Sanguineo: " + inscription.get("sanitizedNumber"));
                    System.out.println("Monto: " + inscription.get("amount"));
                    System.out.println("Numero: " + inscription.get("number") + "\n");
                }
            }
        }

    }

    public static boolean validateMember(String dni, int category) {
        for (Map<String, Object> inscription : inscriptions) {
            if (inscription.get("dni").equals(dni)){
                System.out.printf("\n !El Participante ya se encuentra registrado en la categoria %s\n",categories.get(category)[0]);
                return false;
            }
        }
        return true;
    }

    public static void deleteMember(String dni) {
        for (Map<String, Object> inscription : inscriptions) {
            if (inscription.get("dni").equals(dni)){
                inscriptions.remove(inscription);
                System.out.println("El Participante se ha eliminado correctamente");
                return;
            }
        }
        System.out.println("El Participante no esta registrado");
    }

    public static void getAmountByCategory() {

        for (int i = 1; i <= 3; i++) {
            double total = 0;
            System.out.printf("\n--- CATEGORIA %s ---\n",categories.get(i)[0]);
            for (Map<String, Object> inscription : inscriptions) {
                if (inscription.get("category").equals(categories.get(i))) {
                    total += (Double) inscription.get("amount");
                }
            }
            System.out.println("Total: " + total);
        }
    }

    public static void getAmountTotal() {
        double total = 0;
        for (Map<String, Object> inscription : inscriptions) {
            total += (Double) inscription.get("amount");
        }
        System.out.println("Total de la Carrera: " + total);
    }




}
