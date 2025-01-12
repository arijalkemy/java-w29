//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Mapas para manejar las categorías y las inscripciones
        Map<String, List<Map<String, Object>>> categorias = new HashMap<>();
        Map<Integer, Map<String, Object>> inscripciones = new HashMap<>();

        // Crear las 3 categorías
        categorias.put("Circuito chico", new ArrayList<>());
        categorias.put("Circuito medio", new ArrayList<>());
        categorias.put("Circuito avanzado", new ArrayList<>());

        // Crear un participante y calcular monto (por ejemplo, inscribir un participante de 21 años)
        inscribirParticipante(inscripciones, categorias, 1, "Juan", "Pérez", 21, "12345678", "11223344", "911223344", "O+", "Circuito chico");
        inscribirParticipante(inscripciones, categorias, 2, "Pedro", "González", 17, "23456789", "22334455", "911334455", "A+", "Circuito medio");
        inscribirParticipante(inscripciones, categorias, 3, "María", "López", 25, "34567890", "33445566", "911445566", "B+", "Circuito avanzado");

        // Mostrar los inscriptos en una categoría
        mostrarInscriptos(categorias, "Circuito chico");
        mostrarInscriptos(categorias, "Circuito medio");
        mostrarInscriptos(categorias, "Circuito avanzado");

        // Desinscribir un participante
        desinscribirParticipante(inscripciones, categorias, 2);

        // Mostrar nuevamente los inscriptos tras la desinscripción
        mostrarInscriptos(categorias, "Circuito medio");

        // Calcular el monto total recaudado por cada categoría
        double totalChico = calcularMontoTotalPorCategoria(inscripciones, "Circuito chico");
        double totalMedio = calcularMontoTotalPorCategoria(inscripciones, "Circuito medio");
        double totalAvanzado = calcularMontoTotalPorCategoria(inscripciones, "Circuito avanzado");
        double totalCarrera = totalChico + totalMedio + totalAvanzado;

        // Mostrar los totales
        System.out.println("Monto total recaudado por Circuito chico: $" + totalChico);
        System.out.println("Monto total recaudado por Circuito medio: $" + totalMedio);
        System.out.println("Monto total recaudado por Circuito avanzado: $" + totalAvanzado);
        System.out.println("Monto total de la carrera: $" + totalCarrera);
    }

    // Función para inscribir a un participante
    public static void inscribirParticipante(Map<Integer, Map<String, Object>> inscripciones,
                                             Map<String, List<Map<String, Object>>> categorias,
                                             int numeroInscripcion, String nombre, String apellido, int edad,
                                             String dni, String celular, String numeroEmergencia,
                                             String grupoSanguineo, String categoria) {
        // Crear un mapa para la inscripción
        Map<String, Object> inscripcion = new HashMap<>();
        inscripcion.put("nombre", nombre);
        inscripcion.put("apellido", apellido);
        inscripcion.put("edad", edad);
        inscripcion.put("dni", dni);
        inscripcion.put("celular", celular);
        inscripcion.put("numeroEmergencia", numeroEmergencia);
        inscripcion.put("grupoSanguineo", grupoSanguineo);

        // Calcular monto de inscripción basado en la edad
        double monto = calcularMonto(categoria, edad);
        inscripcion.put("monto", monto);

        // Almacenar la inscripción en el mapa de inscripciones
        inscripciones.put(numeroInscripcion, inscripcion);

        // Agregar el participante a la lista de la categoría
        Map<String, Object> categoriaInscripcion = new HashMap<>();
        categoriaInscripcion.put("numeroInscripcion", numeroInscripcion);
        categoriaInscripcion.put("monto", monto);
        categorias.get(categoria).add(categoriaInscripcion);
    }

    // Función para calcular el monto de la inscripción
    public static double calcularMonto(String categoria, int edad) {
        double monto = 0;
        if (categoria.equals("Circuito chico")) {
            monto = (edad < 18) ? 1300 : 1500;
        } else if (categoria.equals("Circuito medio")) {
            monto = (edad < 18) ? 2000 : 2300;
        } else if (categoria.equals("Circuito avanzado")) {
            if (edad < 18) {
                System.out.println("No se permite inscripción a menores de 18 años en Circuito avanzado.");
                return 0; // No se permite inscripción
            }
            monto = 2800;
        }
        return monto;
    }

    // Función para mostrar los inscriptos en una categoría
    public static void mostrarInscriptos(Map<String, List<Map<String, Object>>> categorias, String categoria) {
        System.out.println("Inscriptos en " + categoria + ":");
        for (Map<String, Object> inscripcion : categorias.get(categoria)) {
            int numeroInscripcion = (int) inscripcion.get("numeroInscripcion");
            Map<String, Object> participante = getInscripcionById(numeroInscripcion);
            System.out.println("Número de Inscripción: " + numeroInscripcion +
                    ", Nombre: " + participante.get("nombre") + " " + participante.get("apellido") +
                    ", Monto: $" + inscripcion.get("monto"));
        }
    }

    // Función para obtener los datos de una inscripción por ID
    public static Map<String, Object> getInscripcionById(int numeroInscripcion) {
        // Este es el mapa global de inscripciones, lo utilizamos para recuperar los datos
        return Main.inscripciones.get(numeroInscripcion);
    }

    // Función para desinscribir a un participante
    public static void desinscribirParticipante(Map<Integer, Map<String, Object>> inscripciones,
                                                Map<String, List<Map<String, Object>>> categorias,
                                                int numeroInscripcion) {
        // Eliminar la inscripción del mapa de inscripciones
        inscripciones.remove(numeroInscripcion);

        // Eliminar el participante de la lista de inscriptos en la categoría correspondiente
        for (String categoria : categorias.keySet()) {
            categorias.get(categoria).removeIf(inscripcion -> inscripcion.get("numeroInscripcion").equals(numeroInscripcion));
        }

        System.out.println("Participante con número de inscripción " + numeroInscripcion + " desinscripto.");
    }

    // Función para calcular el monto total recaudado por una categoría
    public static double calcularMontoTotalPorCategoria(Map<Integer, Map<String, Object>> inscripciones,
                                                        String categoria) {
        double total = 0;
        for (Map<String, Object> inscripcion : main.categorias.get(categoria)) {
            int numeroInscripcion = (int) inscripcion.get("numeroInscripcion");
            total += (double) inscripciones.get(numeroInscripcion).get("monto");
        }
        return total;
    }
}
