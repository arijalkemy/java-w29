import java.util.*;

public class Main {

    static Map<Integer, List<String>> circuitos = Map.of(
            1, Arrays.asList("Circuito chico", "2 km por selva y arroyos"),
            2, Arrays.asList("Circuito medio", "5 km por selva, arroyos y barro"),
            3, Arrays.asList("Circuito avanzado", "10km por selva, arroyos, barro y escalada en piedra"));

    static Map<Integer, Map<String, String>> participantes = Map.of(
            1, Map.of(
                    "Numero de participante", "123",
                    "nombre", "Brayan",
                    "apellido", "Arellano",
                    "edad", "22",
                    "celular", "123456789",
                    "numero de emergencia", "987654321",
                    "grupo sangineo", "A+"
            ),
            2, Map.of(
                    "Numero de participante", "123",
                    "nombre", "Brayan",
                    "apellido", "Arellano",
                    "edad", "16",
                    "celular", "123456789",
                    "numero de emergencia", "987654321",
                    "grupo sangineo", "A+"
            ),
            3, Map.of(
                    "Numero de participante", "123",
                    "nombre", "Brayan",
                    "apellido", "Arellano",
                    "edad", "34",
                    "celular", "123456789",
                    "numero de emergencia", "987654321",
                    "grupo sangineo", "A+"
            )
    );

    static Map<Integer, List<Integer>> inscripciones = new HashMap<>();

    public static void main(String[] args) {
        // C
        agregarParticipante(1, 1);
        agregarParticipante(2, 2);
        agregarParticipante(3, 3);
        System.out.println(inscripciones);

        // D
        mostrarParticipantesEnCategoria(1);
        mostrarParticipantesEnCategoria(2);
        mostrarParticipantesEnCategoria(3);

        // E
        desincribirParticipante(1);

        // F
        calcularMonto();
    }

    private static void agregarParticipante(int dni, int idCircuito) {
        int idInscripcion = inscripciones.size() + 1;

        int monto = 0;
        int edad = Integer.parseInt(participantes.get(dni).get("edad"));

        switch (idCircuito) {
            case 1:
                monto = edad < 18 ? 1300 : 1500;
                break;
            case 2:
                monto = edad < 18 ? 2000 :2300;
                break;
            case 3:
                if (edad <18){
                    System.out.println("No se permite inscribir menores de 18 años en el circuito abanzado");
                    return;
                }
                monto = 2800;
                break;
        }

        for (Integer i : inscripciones.keySet()) {
            if (inscripciones.get(i).get(1).equals(dni)) {
                System.out.println("El participante ya esta inscrito en otra categoria");
                return;
            }
        }

        inscripciones.put(idInscripcion, Arrays.asList(idCircuito, dni, monto));
    }

    private static void mostrarParticipantesEnCategoria(int idCircuito) {
        for (Map.Entry<Integer, List<Integer>> entry : inscripciones.entrySet()) {
            int idInscripcion = entry.getKey();
            int idCategoria = entry.getValue().get(0);
            if (idCategoria == idCircuito) {
                int dni = entry.getValue().get(1);
                System.out.println("Participante: " + participantes.get(dni) + "Con inscripcion: " + idInscripcion);
            }
        }
    }

    private static void desincribirParticipante(int idInscripcion) {
        int idCategoria = inscripciones.get(idInscripcion).get(0);
        inscripciones.remove(idInscripcion);
        mostrarParticipantesEnCategoria(idCategoria);
    }

    private static void calcularMonto() {
        int[] montos = new int[3];

        for (Integer i : inscripciones.keySet()) {
            int categoria = inscripciones.get(i).get(0);
            int monto = inscripciones.get(i).get(2);

            montos[categoria - 1] += monto;
        }
        System.out.println("Monto de chico: " + montos[0]);
        System.out.println("Monto de medio: " + montos[1]);
        System.out.println("Monto de avanzado: " + montos[2]);
        System.out.println("Monto total: " + (montos[0] + montos[1] + montos[2]));
    }

}
