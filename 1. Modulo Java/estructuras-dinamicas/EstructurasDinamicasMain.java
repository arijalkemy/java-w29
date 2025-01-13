import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EstructurasDinamicasMain {

    public static void main(String[] args) {
        Map<String, ArrayList<String>> categoria = new HashMap<>();
        ArrayList<String> chico = new ArrayList<>();
        chico.add("Circuito Chico");
        chico.add("Dos Kilometros por selva y arroyos");
        categoria.put("Chico", chico);

        ArrayList<String> medio = new ArrayList<>();
        medio.add("Circuito Medio");
        medio.add("5 Kilometros por selva, arroyos y barro");
        categoria.put("Medio", medio);

        ArrayList<String> avanzado = new ArrayList<>();
        avanzado.add("Circuito Avanzado");
        avanzado.add("10 km por selva, arroyos, barro y escalada en piedra");
        categoria.put("Avanzado", avanzado);

        Map<String, Object> participante1 = new HashMap<>();
        participante1.put("Número de Participante", "12345345");
        participante1.put("DNI", "111003321tlgjal");
        participante1.put("Nombre", "Daniel");
        participante1.put("Apellido", "DanielApellido");
        participante1.put("Edad", 20);
        participante1.put("Celular", "555-1234");
        participante1.put("Número de Emergencia", "555-5678");
        participante1.put("Grupo Sanguíneo", "O+");

        Map<String, Object> participante2 = new HashMap<>();
        participante2.put("Número de Participante", "12345375");
        participante2.put("DNI", "111903321tlgjal");
        participante2.put("Nombre", "Daniel");
        participante2.put("Apellido", "DanielApellido");
        participante2.put("Edad", 17);
        participante2.put("Celular", "555-1234");
        participante2.put("Número de Emergencia", "555-5678");
        participante2.put("Grupo Sanguíneo", "O+");

        Map<String, Object> participante3 = new HashMap<>();
        participante3.put("Número de Participante", "12345390");
        participante3.put("DNI", "123321tlgjal");
        participante3.put("Nombre", "Daniel");
        participante3.put("Apellido", "DanielApellido");
        participante3.put("Edad", 56);
        participante3.put("Celular", "555-1234");
        participante3.put("Número de Emergencia", "555-5678");
        participante3.put("Grupo Sanguíneo", "O+");

        ArrayList<Map<String, Object>> inscripcionesChico = new ArrayList<>();
        inscripcionesChico.add(participante1);
        participante1.put("Monto", calcularMonto("Chico", participante1));
        participante1.put("Inscripcion", 1);

        ArrayList<Map<String, Object>> inscripcionesMedio = new ArrayList<>();
        inscripcionesMedio.add(participante2);
        participante2.put("Monto", calcularMonto("Medio", participante2));
        participante2.put("Inscripcion", 2);

        ArrayList<Map<String, Object>> inscripcionesAvanzado = new ArrayList<>();
        inscripcionesAvanzado.add(participante3);
        participante3.put("Monto", calcularMonto("Avanzado", participante3));
        participante3.put("Inscripcion", 3);

        for (Map.Entry<String, Object> entry : participante1.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("Llave: " + key + ", Valor: " + value);
        }

        for (Map.Entry<String, Object> entry : participante2.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("Llave: " + key + ", Valor: " + value);
        }

        for (Map.Entry<String, Object> entry : participante3.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println("Llave: " + key + ", Valor: " + value);
        }
    }

    public static int calcularMonto(String categoria, Map<String, Object> participante) {
        Integer edad = (Integer) participante.get("Edad");
        switch (categoria) {
            case "Chico":
                return edad < 18 ? 1300 : 1500;
            case "Medio":
                return edad < 18 ? 2000 : 2300;
            case "Avanzado":
                return edad >= 18 ? 2800 : -1;
            default:
                return -1;
        }
    }
}