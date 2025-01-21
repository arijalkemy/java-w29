import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear categorías
        Map<String, String> category = new HashMap<>();
        category.put("circuito-chico", "2 km por selva y arroyos.");
        category.put("circuito-medio", "5 km por selva, arroyos y barro.");
        category.put("circuito-avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        // Participantes
        List<Map<String, Object>> participantes = new ArrayList<>();
        participantes.add(Map.of(
                "dni", "12345678",
                "name", "Juan",
                "surname", "Perez",
                "age", 25,
                "phone", "1234567890",
                "emergency", "11234567",
                "bloodType", "O+"));

        participantes.add(Map.of(
                "dni", "3245677",
                "name", "Mati",
                "surname", "Leal",
                "age", 28,
                "phone", "1234567890",
                "emergency", "11234567",
                "bloodType", "O-"));


        // Inscripciones
        List<Map<String, Object>> inscriptions= new ArrayList<>();
        inscriptions.add(Map.of(
                "inscriptionNumber", 1,
                "category", "circuito-chico",
                "applicant", 0,
                "price", getPrice("circuito-chico", 25)));


        // Mostrar participantes inscritos en "circuito-chico"

        printApplicantByCategory(inscriptions, participantes, "circuito-chico");

        // Crear una nueva inscripción

        Map<String, Object> newApplicant = Map.of(
                "dni", "98765282",
                "nanme", "Ana",
                "surname", "Gomez",
                "age", 17,
                "phone", "9876543210",
                "emergency", "11234567",
                "bloodType", "A+");

        newInscription(inscriptions, participantes, "circuito-medio", newApplicant);
    }

    public static double getPrice(String categoria, int edad) {
        switch (categoria) {
            case "circuito-chico":
                return edad < 18 ? 1300 : 1500;
            case "circuito-medio":
                return edad < 18 ? 2000 : 2300;
            case "circuito-avanzado":
                return edad >= 18 ? 2800 : 0; // No se permiten menores
            default:
                throw new IllegalArgumentException("Categoría inválida");
        }
    }

    public static void newInscription(List<Map<String, Object>> inscripciones, List<Map<String, Object>> participantes, String categoria, Map<String, Object> nuevoParticipante) {
        int nuevoNumeroInscripcion = inscripciones.size() + 1;
        int indiceParticipante = participantes.size();
        participantes.add(nuevoParticipante);
        double monto = getPrice(categoria, (int) nuevoParticipante.get("age"));
        inscripciones.add(Map.of(
                "inscriptionNumber", nuevoNumeroInscripcion,
                "category", categoria,
                "applicant", indiceParticipante,
                "price", monto));
    }

    public static void printApplicantByCategory(List<Map<String, Object>> inscriptions, List<Map<String, Object>> applicants, String category) {
        System.out.println("Inscriptos en la categoría " + category + ":");
        for (Map<String, Object> inscripcion : inscriptions) {
            if (inscripcion.get("category").equals(category)) {
                Map<String, Object> participante = applicants.get((int) inscripcion.get("participante"));
                System.out.println(" - " + participante.get("name") + " " + participante.get("surname") + " (Inscripción #" + inscripcion.get("inscriptionNumber") + ")");
            }
        }
    }

    public static void removePerson(List<Map<String, Object>> inscriptions, int inscriptionId) {
        inscriptions.removeIf(i -> (int) i.get("inscriptionNumber") == inscriptionId);
    }
}