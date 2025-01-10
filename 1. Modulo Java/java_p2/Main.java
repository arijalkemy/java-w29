import java.util.*;

public class Main {
  static List<Map<String, Object>> categorias = new ArrayList<>();
  static List<Map<String, Object>> participantes = new ArrayList<>();
  static List<Map<String, Object>> inscripciones = new ArrayList<>();

  public static void addInsripcion(Map<String, Object> inscripcion){
    Integer montoAbonar = 0;
    Integer edad = (Integer) ((Map) inscripcion.get("participante")).get("edad");
    if(inscripcion.get("categoria") == categorias.get(0)){
      if(edad < 18) montoAbonar = 1300;
      else montoAbonar = 1500;
    } else if(inscripcion.get("categoria") == categorias.get(1)){
      if(edad < 18) montoAbonar = 2000;
      else montoAbonar = 2300;
    } else if(inscripcion.get("categoria") == categorias.get(2)){
      if(edad < 18) montoAbonar = null;
      else montoAbonar = 2800;
    }
    if(montoAbonar == null){
      System.out.println("No se puede inscribir a menores de edad en esta categoria");
      return;
    }

    inscripciones.add(
      Map.of(
        "numeroInscripcion", inscripcion.get("numeroInscripcion"),
        "categoria", inscripcion.get("categoria"),
        "participante", inscripcion.get("participante"),
        "montoAbonar", montoAbonar
      )
    );
  }

  public static void deleteInscripcion(Map<String, Object> participante){
    inscripciones.removeIf(inscripcion -> inscripcion.get("participante") == participante);
  }

  public static void main(String[] args) {
    categorias = List.of(
      Map.of("nombre", "Circuito chico", "descripcion", "2 km por selva y arroyos."),
      Map.of("nombre", "Circuito medio", "descripcion", "5 km por selva, arroyos y barro."),
      Map.of("nombre", "Circuito Avanzado", "descripcion", "10 km por selva, arroyos, barro y escalada en piedra.")
    );

    participantes = List.of(
      Map.of("numeroParticipante", 1, "dni", "12345678", "nombre", "Edward", "apellido", "Soto", "edad", 25, "celular", "987654321", "numeroEmergencia", "123456789", "grupoSanguineo", "O+"),
      Map.of("numeroParticipante", 2, "dni", "87654321", "nombre", "Juan", "apellido", "Perez", "edad", 30, "celular", "123456789", "numeroEmergencia", "987654321", "grupoSanguineo", "A+"),
      Map.of("numeroParticipante", 3, "dni", "45678912", "nombre", "Maria", "apellido", "Gomez", "edad", 35, "celular", "456789123", "numeroEmergencia", "456789123", "grupoSanguineo", "B+")
    );

    Main.addInsripcion(Map.of(
      "numeroInscripcion", 1, 
      "categoria", categorias.get(0), 
      "participante", participantes.get(0)
    ));
    Main.addInsripcion(Map.of(
      "numeroInscripcion", 2, 
      "categoria", categorias.get(1), 
      "participante", participantes.get(1)
    ));
    Main.addInsripcion(Map.of(
      "numeroInscripcion", 3, 
      "categoria", categorias.get(2), 
      "participante", participantes.get(2)
    ));

    System.out.println("=======================");
    System.out.println("Inscripciones en la categoria Circuito chico:");
    inscripciones.stream()
      .filter(inscripcion -> inscripcion.get("categoria") == categorias.get(0))
      .forEach(inscripcion -> System.out.println(inscripcion.get("participante")));
    System.out.println("=======================");
    System.out.println("Inscripciones en la categoria Circuito medio:");
    inscripciones.stream()
      .filter(inscripcion -> inscripcion.get("categoria") == categorias.get(1))
      .forEach(inscripcion -> System.out.println(inscripcion.get("participante")));
    System.out.println("=======================");
    System.out.println("Inscripciones en la categoria Circuito Avanzado:");
    inscripciones.stream()
      .filter(inscripcion -> inscripcion.get("categoria") == categorias.get(2))
      .forEach(inscripcion -> System.out.println(inscripcion.get("participante")));
    Main.deleteInscripcion(participantes.get(0));
    System.out.println("=======================");
    System.out.println("Inscripciones en la categoria Circuito chico:");
    inscripciones.stream()
      .filter(inscripcion -> inscripcion.get("categoria") == categorias.get(0))
      .forEach(inscripcion -> System.out.println(inscripcion.get("participante")));
    
    Integer value = inscripciones.stream()
      .filter(inscripcion -> inscripcion.get("categoria") == categorias.get(0))
      .mapToInt(inscripcion -> (Integer) inscripcion.get("montoAbonar"))
      .sum();
    System.out.println("=======================");
    System.out.println("Total categoria chico: " + value);
    value = inscripciones.stream()
      .filter(inscripcion -> inscripcion.get("categoria") == categorias.get(1))
      .mapToInt(inscripcion -> (Integer) inscripcion.get("montoAbonar"))
      .sum();
    System.out.println("=======================");
    System.out.println("Total categoria medio: " + value);
    value = inscripciones.stream()
      .filter(inscripcion -> inscripcion.get("categoria") == categorias.get(2))
      .mapToInt(inscripcion -> (Integer) inscripcion.get("montoAbonar"))
      .sum();
    System.out.println("=======================");
    System.out.println("Total categoria avanzado: " + value);
    value = inscripciones.stream()
      .mapToInt(inscripcion -> (Integer) inscripcion.get("montoAbonar"))
      .sum();
    System.out.println("=======================");
    System.out.println("Total todas las categorias: " + value);
  }
}