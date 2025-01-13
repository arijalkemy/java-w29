package CarreraSelva;

import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;


public class Main {
    public static double calcularMonto(int edad, String circuito){
        double monto = 0;
        if (circuito.equals("chico")) {
            monto = edad < 18 ? 1300 : 1500;
        }
        if (circuito.equals("medio")) {
            monto = edad < 18 ? 2000 : 2300;
        }
        if (circuito.equals("avanzado")) {
            monto = edad < 18 ? 0 : 2800;
        }
        return monto;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opt = 0;
        Map<String, String> categories = new HashMap<>();
        Map<String, Map<String, Object>> participantes = new HashMap<>();
        Map<String, Map<String, Object>> inscripciones = new HashMap<>();

        categories.put("chico", "2 km por selva y arroyos.");
        categories.put("medio", "5 km por selva, arroyos y barro.");
        categories.put("avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        do {
            System.out.println("Selecciona opción: \n 1. Anadir participante \n 2. Listar \n 3. Salir" );
            opt = sc.nextInt();
            if(opt == 1) {
                System.out.println("Ingresa el numero de participante");
                sc.nextLine();
                String idParticipante = sc.nextLine();
                participantes.put(idParticipante, new HashMap<String, Object>() {{
                    System.out.println("Ingresa el dni: ");
                    put("dni", sc.nextLine());
                    System.out.println("Ingresa el nombre: ");
                    put("nombre", sc.nextLine());
                    System.out.println("Ingresa el apellido: ");
                    put("apellido", sc.nextLine());
                    System.out.println("Ingresa la edad: ");
                    put("edad", sc.nextInt());
                    sc.nextLine();
                    System.out.println("Ingresa el celular: ");
                    put("celular", sc.nextLine());
                    System.out.println("Ingresa el tel de emergencia: ");
                    put("telEmergencia", sc.nextLine());
                    System.out.println("Ingresa el rh: ");
                    put("rh", sc.nextLine());
                }});
                System.out.println("Ingresa el numero de inscripcion");
                String idInscripcion = sc.nextLine();
                inscripciones.put(idInscripcion, new HashMap<String, Object>() {{
                    put("Participante", participantes.get(idParticipante));
                    System.out.println("Ingresa el nombre de la categoria");
                    put("Categoria", categories.get(sc.nextLine()));
                    put("Monto", calcularMonto((Integer) participantes.get(idParticipante).get("edad"), "avanzado"));
                }});
                System.out.println(inscripciones.get(idInscripcion).get("Monto"));
                if((Double) inscripciones.get(idInscripcion).get("Monto") == 0) {
                    inscripciones.remove(idInscripcion);
                    participantes.remove(idParticipante);
                    System.out.println("Participante menor edad para categoria.");
                    continue;
                }
                System.out.println("Inscripcion finalizada");
            } else if (opt == 2) {
                for(Map.Entry<String, Map<String, Object>> incripcion : inscripciones.entrySet()) {
                    System.out.println(incripcion.getKey() + ": " + incripcion.getValue());
                }
            }
        } while(opt != 3);
    }
}
