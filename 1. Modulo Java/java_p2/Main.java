import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {
  static List<Map<String, Object>> categorias = new ArrayList<>();
  String fields_categorias[] = { "nombre", "descripcion" };

  static List<Map<String, Object>> participantes = new ArrayList<>();
  String fields_participantes[] = { "dni", "nombre", "apellido", "edad", "celular", "numeroEmergencia", "grupoSanguineo" };
  
  static List<Map<String, Object>> inscripciones = new ArrayList<>();
  String fields_inscripciones[] = { "categoria", "participante", "montoAbonar" };  

  public static void main(String[] args) {
    // categorias
    Map<String, Object> carrera1 = new HashMap<>();
    carrera1.put("nombre", "Circuito chico");
    carrera1.put("descripcion", "2 km por selva y arroyos.");
    categorias.add(carrera1);

    Map<String, Object> carrera2 = new HashMap<>();
    carrera2.put("nombre", "Circuito medio");
    carrera2.put("descripcion", "5 km por selva, arroyos y barro.");
    categorias.add(carrera2);

    Map<String, Object> carrera3 = new HashMap<>();
    carrera3.put("nombre", "Circuito Avanzado");
    carrera3.put("descripcion", "10 km por selva, arroyos, barro y escalada en piedra.");
    categorias.add(carrera3);

    // participantes
    Map<String, Object> participante1 = new HashMap<>();
    participante1.put("numeroParticipante", 1);
    participante1.put("dni", "12345678");
    participante1.put("nombre", "Edward");
    participante1.put("apellido", "Soto");
    participante1.put("edad", 25);
    participante1.put("celular", "987654321");
    participante1.put("numeroEmergencia", "123456789");
    participante1.put("grupoSanguineo", "O+");
    participantes.add(participante1);
  
    // inscripciones
    Map<String, Object> inscripcion1 = new HashMap<>();
    inscripcion1.put("numeroInscripcion", 1);
    inscripcion1.put("categoria", carrera1);
    inscripcion1.put("participante", "Edward Soto");
    inscripcion1.put("montoAbonar", 50.0);
    inscripcion1.put("participante", participante1);
    inscripciones.add(inscripcion1);

    for (Map<String, Object> inscripcion : inscripciones){
      System.out.println(inscripcion);
    }
  }
}