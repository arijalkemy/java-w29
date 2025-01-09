import java.util.*;

public class CarreraSelva {

    public static void main(String[] args) {

        Map<Integer, Map<String, String>> categorias = new HashMap<>();
        List<Map<String, Object>> inscripciones = new ArrayList<>();

        // Definir categorías usando Maps
        categorias.put(1, Map.of("nombre", "Circuito chico", "descripcion", "2 km por selva y arroyos."));
        categorias.put(2, Map.of("nombre", "Circuito medio", "descripcion", "5 km por selva, arroyos y barro."));
        categorias.put(3, Map.of("nombre", "Circuito avanzado", "descripcion", "10 km por selva, arroyos, barro y escalada en piedra."));

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("1. Listar inscritos");
            System.out.println("2. Inscribir participante");
            System.out.println("3. Desinscribir participante");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            System.out.println("La opcion es: " + opcion);

            switch (opcion) {
                case 1:
                    listarInscritos(inscripciones);
                    break;
                case 2:
                    inscribirParticipante(scanner, inscripciones, categorias);
                    break;
                case 3:
                    desinscribirParticipante(scanner, inscripciones);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
        scanner.close();
    }

    public static void listarInscritos(List<Map<String, Object>> inscripciones) {
        if (inscripciones.isEmpty()) {
            System.out.println("No hay inscritos.\n");
        } else {
            System.out.println("Listado de inscritos:");
            for (Map<String, Object> inscripcion : inscripciones) {
                System.out.println("Nº Inscripción: " + inscripcion.get("numeroInscripcion") +
                        ", Participante: " + inscripcion.get("nombre") + " " + inscripcion.get("apellido") +
                        ", Categoría: " + inscripcion.get("categoria") + ", Descripción: " + inscripcion.get("descripcion") +
                        ", Monto: $" + inscripcion.get("monto"));
            }
            System.out.println();
        }
    }

    public static void listarCategorias(Map<Integer, Map<String, String>> categorias) {
        System.out.println("Listado de categorías:");
        for (Map.Entry<Integer, Map<String, String>> categoria : categorias.entrySet()) {
            System.out.println("ID: " + categoria.getKey() + ", Nombre: " + categoria.getValue().get("nombre") +
                    ", Descripción: " + categoria.getValue().get("descripcion"));
        }
        System.out.println();
    }

    public static void inscribirParticipante(Scanner scanner, List<Map<String, Object>> inscripciones, Map<Integer, Map<String, String>> categorias) {
        System.out.print("Número de inscripción: ");
        int numeroInscripcion = inscripciones.size() + 1;
        listarCategorias(categorias);
        System.out.print("Número de categoría: ");
        int categoriaId = scanner.nextInt();
        System.out.print("DNI: ");
        String dni = scanner.next();

        // Verificar si ya está inscrito
        if (estaInscrito(dni, inscripciones)) {
            System.out.println("El participante con DNI " + dni + " ya está inscrito en una categoría.\n");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Apellido: ");
        String apellido = scanner.next();
        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        System.out.print("Celular: ");
        String celular = scanner.next();
        System.out.print("Número de emergencia: ");
        String numeroEmergencia = scanner.next();
        System.out.print("Grupo sanguíneo: ");
        String grupoSanguineo = scanner.next();

        if (categorias.containsKey(categoriaId)) {
            String categoriaNombre = categorias.get(categoriaId).get("nombre");
            double monto = calcularMonto(edad, categoriaNombre);

            if (monto > 0) {
                Map<String, Object> inscripcion = new HashMap<>();
                inscripcion.put("numeroInscripcion", numeroInscripcion);
                inscripcion.put("categoria", categoriaNombre);
                inscripcion.put("descripcion", categorias.get(categoriaId).get("descripcion"));
                inscripcion.put("dni", dni);
                inscripcion.put("nombre", nombre);
                inscripcion.put("apellido", apellido);
                inscripcion.put("edad", edad);
                inscripcion.put("celular", celular);
                inscripcion.put("numeroEmergencia", numeroEmergencia);
                inscripcion.put("grupoSanguineo", grupoSanguineo);
                inscripcion.put("monto", monto);
                inscripciones.add(inscripcion);
                System.out.println("Participante inscrito correctamente.\n");
            } else {
                System.out.println("No se puede inscribir debido a restricciones de edad para la categoría seleccionada.\n");
            }
        } else {
            System.out.println("La categoría no existe.\n");
        }
    }

    private static boolean estaInscrito(String dni, List<Map<String, Object>> inscripciones) {
        for (Map<String, Object> inscripcion : inscripciones) {
            if (inscripcion.get("dni").equals(dni)) {
                return true;
            }
        }
        return false;
    }

    private static double calcularMonto(int edad, String categoria) {
        switch (categoria) {
            case "Circuito chico":
                return (edad < 18) ? 1300 : 1500;
            case "Circuito medio":
                return (edad < 18) ? 2000 : 2300;
            case "Circuito avanzado":
                return (edad >= 18) ? 2800 : 0;
            default:
                return 0;
        }
    }

    public static void desinscribirParticipante(Scanner scanner, List<Map<String, Object>> inscripciones) {
        System.out.print("Número de inscripción a desinscribir: ");
        int numeroInscripcion = scanner.nextInt();
        boolean encontrado = false;
        for (Map<String, Object> inscripcion : inscripciones) {
            if ((int) inscripcion.get("numeroInscripcion") == numeroInscripcion) {
                inscripciones.remove(inscripcion);
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("Participante desinscrito correctamente.\n");
        } else {
            System.out.println("Número de inscripción no encontrado.\n");
        }
    }
}
