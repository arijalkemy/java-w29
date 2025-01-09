public class Main {
    public static void main(String[] args) {

        // Definición de categorías
        Map<String, String> categorias = new HashMap<>();
        categorias.put("chico", "2 km por selva y arroyos.");
        categorias.put("medio", "5 km por selva, arroyos y barro.");
        categorias.put("avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        // Lista de inscripciones
        List<Map<String, Object>> inscripciones = new ArrayList<>();

        // Inscribir algunos participantes
        inscribir(inscripciones, categorias, 1, "chico", 12345678, "Juan Perez", 16);
        inscribir(inscripciones, categorias, 2, "medio", 23456789, "Ana Gomez", 20);
        inscribir(inscripciones, categorias, 3, "avanzado", 34567890, "Luis Martinez", 25);
        inscribir(inscripciones, categorias, 4, "medio", 45678901, "Pedro Lopez", 17);

        // Mostrar inscriptos en una categoría
        mostrarInscriptos(inscripciones, "medio");

        // Desinscribir a un participante
        desinscribir(inscripciones, 2);

        // Mostrar lista actualizada
        mostrarInscriptos(inscripciones, "medio");

        // Calcular recaudación
        calcularRecaudacion(inscripciones);
    }

    // Método para inscribir a un participante
    public static void inscribir(List<Map<String, Object>> inscripciones, Map<String, String> categorias,
                                 int numeroInscripcion, String categoria, int dni, String nombre, int edad) {
        // Validar categoría y calcular monto
        int monto = calcularMonto(categoria, edad);
        if (monto == -1) {
            System.out.println("No se pudo inscribir a " + nombre + " en la categoría " + categoria + ".");
            return;
        }

        // Crear inscripción
        Map<String, Object> inscripcion = new HashMap<>();
        inscripcion.put("numeroInscripcion", numeroInscripcion);
        inscripcion.put("categoria", categoria);
        inscripcion.put("dni", dni);
        inscripcion.put("nombre", nombre);
        inscripcion.put("edad", edad);
        inscripcion.put("monto", monto);

        // Agregar inscripción a la lista
        inscripciones.add(inscripcion);
        System.out.println("Inscripción exitosa: " + nombre + " en " + categoria + " por $" + monto);
    }

    // Método para calcular el monto según la categoría y la edad
    public static int calcularMonto(String categoria, int edad) {
        switch (categoria) {
            case "chico":
                return (edad < 18) ? 1300 : 1500;
            case "medio":
                return (edad < 18) ? 2000 : 2300;
            case "avanzado":
                return (edad >= 18) ? 2800 : -1;
            default:
                System.out.println("Categoría inválida.");
                return -1;
        }
    }

    // Método para mostrar los inscriptos en una categoría
    public static void mostrarInscriptos(List<Map<String, Object>> inscripciones, String categoria) {
        System.out.println("\nInscriptos en " + categoria + ":");
        for (Map<String, Object> inscripcion : inscripciones) {
            if (inscripcion.get("categoria").equals(categoria)) {
                System.out.println("Nro: " + inscripcion.get("numeroInscripcion") +
                        ", Nombre: " + inscripcion.get("nombre") +
                        ", DNI: " + inscripcion.get("dni") +
                        ", Edad: " + inscripcion.get("edad") +
                        ", Monto: $" + inscripcion.get("monto"));
            }
        }
    }

    // Método para desinscribir a un participante por número de inscripción
    public static void desinscribir(List<Map<String, Object>> inscripciones, int numeroInscripcion) {
        boolean eliminado = inscripciones.removeIf(inscripcion ->
                inscripcion.get("numeroInscripcion").equals(numeroInscripcion)
        );
        if (eliminado) {
            System.out.println("\nEl participante con inscripción " + numeroInscripcion + " ha sido eliminado.");
        } else {
            System.out.println("\nNo se encontró el número de inscripción " + numeroInscripcion + ".");
        }
    }

    // Método para calcular la recaudación total
    public static void calcularRecaudacion(List<Map<String, Object>> inscripciones) {
        Map<String, Integer> recaudacionPorCategoria = new HashMap<>();
        int totalGeneral = 0;

        for (Map<String, Object> inscripcion : inscripciones) {
            String categoria = (String) inscripcion.get("categoria");
            int monto = (int) inscripcion.get("monto");
            recaudacionPorCategoria.put(categoria, recaudacionPorCategoria.getOrDefault(categoria, 0) + monto);
            totalGeneral += monto;
        }

        System.out.println("\nRecaudación:");
        for (String categoria : recaudacionPorCategoria.keySet()) {
            System.out.println("Categoría " + categoria + ": $" + recaudacionPorCategoria.get(categoria));
        }
        System.out.println("Total general: $" + totalGeneral);
    }
}
