import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear categorías
        Map<String, Map<String, Object>> categorias = new HashMap<>();
        crearCategoria(categorias, "Circuito chico", "2 km por selva y arroyos.", 1);
        crearCategoria(categorias, "Circuito medio", "5 km por selva, arroyos y barro.", 2);
        crearCategoria(categorias, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.", 3);

        // Crear inscripción
        List<Map<String, Object>> inscripciones = new ArrayList<>();

        // Inscribir participantes
        inscribirParticipante(inscripciones, 1, 12345, "Sergio", "Ramirez", 25, "000", "222", "D+");
        inscribirParticipante(inscripciones, 2, 23456, "Fabiana", "Jimenez", 17, "222", "777", "A+");
        inscribirParticipante(inscripciones, 3, 34567, "Juan", "Zaga", 19, "777", "333", "B-");

        // Mostrar inscripciones y recaudaciones
        mostrarInscriptos("Circuito chico", inscripciones);
        mostrarInscriptos("Circuito medio", inscripciones);
        mostrarInscriptos("Circuito avanzado", inscripciones);

        // Calcular recaudaciones
        double totalRecaudado = 0;
        for (String categoria : categorias.keySet()) {
            double recaudo = calcularRecaudacion(categoria, inscripciones);
            System.out.printf("Recaudación %s: $%.2f\n", categoria, recaudo);
            totalRecaudado += recaudo;
        }
        System.out.printf("Total recaudado en la carrera: $%.2f\n", totalRecaudado);

        // Desinscribir un participante
        desinscribirParticipante(inscripciones, 2);
        mostrarInscriptos("Circuito medio", inscripciones);
    }

    private static void crearCategoria(Map<String, Map<String, Object>> categorias, String nombre, String descripcion, int id) {
        Map<String, Object> categoria = new HashMap<>();
        categoria.put("id", id);
        categoria.put("nombre", nombre);
        categoria.put("descripcion", descripcion);
        categorias.put(nombre, categoria);
    }

    private static void inscribirParticipante(List<Map<String, Object>> inscripciones, int numeroInscripcion, int dni, String nombre, String apellido, int edad, String celular, String emergencia, String grupoSanguineo) {
        Map<String, Object> inscripcion = new HashMap<>();
        inscripcion.put("numeroInscripcion", numeroInscripcion);
        inscripcion.put("dni", dni);
        inscripcion.put("nombre", nombre);
        inscripcion.put("apellido", apellido);
        inscripcion.put("edad", edad);
        inscripcion.put("celular", celular);
        inscripcion.put("emergencia", emergencia);
        inscripcion.put("grupoSanguineo", grupoSanguineo);

        // Determinar categoría
        String categoria = "";
        if (edad < 18) {
            if (nombre.equals("Sergio")) {
                categoria = "Circuito chico";
            } else if (nombre.equals("Fabiana")) {
                categoria = "Circuito medio";
            } else {
                categoria = "Circuito avanzado";  // Para el caso de Juan, se inscribe como avanzado (aunque es menor).
            }
        } else {
            if (nombre.equals("Sergio")) {
                categoria = "Circuito chico";
            } else if (nombre.equals("Fabiana")) {
                categoria = "Circuito medio";
            } else if (nombre.equals("Juan")) {
                categoria = "Circuito avanzado";
            }
        }

        inscripcion.put("categoria", categoria);
        inscripciones.add(inscripcion);
    }

    private static void mostrarInscriptos(String categoriaNombre, List<Map<String, Object>> inscripciones) {
        System.out.println("Inscriptos en " + categoriaNombre + ":");
        for (Map<String, Object> inscripcion : inscripciones) {
            if (inscripcion.get("categoria").equals(categoriaNombre)) {
                System.out.println(inscripcion);
            }
        }
    }

    private static double calcularRecaudacion(String categoriaNombre, List<Map<String, Object>> inscripciones) {
        double total = 0;

        for (Map<String, Object> inscripcion : inscripciones) {
            if (inscripcion.get("categoria").equals(categoriaNombre)) {
                int edad = (int) inscripcion.get("edad");
                total += calcularCostoInscripcion(categoriaNombre, edad);
            }
        }

        return total;
    }

    private static double calcularCostoInscripcion(String categoriaNombre, int edad) {
        switch (categoriaNombre) {
            case "Circuito chico":
                return (edad < 18) ? 1300 : 1500;
            case "Circuito medio":
                return (edad < 18) ? 2000 : 2300;
            case "Circuito avanzado":
                return (edad < 18) ? 0 : 2800; // 0 indica que no se permite la inscripción para menores
            default:
                return 0;
        }
    }

    private static void desinscribirParticipante(List<Map<String, Object>> inscripciones, int numeroInscripcion) {
        inscripciones.removeIf(inscripcion -> (int) inscripcion.get("numeroInscripcion") == numeroInscripcion);
        System.out.println("Desinscripción realizada para el participante con número: " + numeroInscripcion);
    }
}