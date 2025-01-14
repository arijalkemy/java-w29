import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Map<String, String> circuitos = new HashMap<>();
        Map<String,Object> inscripciones = new HashMap<>();


        circuitos.put("circuito chico","2km por selva y arrollos.");
        circuitos.put("circuito medio","5km por selva y arrollos.");
        circuitos.put("cirucito avanazado","10km por selva y arrollos.");

        Map<String, Object> participante_1 = new HashMap<>();
        Map<String, Object> participante_2 = new HashMap<>();
        Map<String, Object> participante_3 = new HashMap<>();

        inscripciones.put("dni", 12345678);
        inscripciones.put("nombre", "Juan");
        inscripciones.put("apellido", "Pérez");
        inscripciones.put("edad", 28);
        inscripciones.put("celular", "+5491123456789");
        inscripciones.put("numero emergencia", "+5491123456789");
        inscripciones.put("grupo sanguineo", "O+");

        inscripciones.put("dni", 87654321);
        inscripciones.put("nombre", "María");
        inscripciones.put("apellido", "López");
        inscripciones.put("edad", 34);
        inscripciones.put("celular", "+5491134567890");
        inscripciones.put("numero emergencia", "+5491134567890");
        inscripciones.put("grupo sanguineo", "A-");

        inscripciones.put("dni", 11223344);
        inscripciones.put("nombre", "Carlos");
        inscripciones.put("apellido", "González");
        inscripciones.put("edad", 25);
        inscripciones.put("celular", "+5491145678901");
        inscripciones.put("numero emergencia", "+5491145678901");
        inscripciones.put("grupo sanguineo", "B+");









    }
}
