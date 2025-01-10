import java.util.*;

public class CarreraDeLaSelva {
    public static void inscribirParticipante (List<Map<String,Object>> inscripciones, int numParticipante, int dni,
                                              String nombre, String apellido, int edad, int celular, int numEmergencia,
                                              String grupoSanguineo, String categoria, int numInscripcion){
        int monto = calcularMonto(categoria, edad);
        // pequeña validacion
        if (monto == 0){
            System.out.println("El participante es menor de edad");
            return;
        }
        Map<String,Object> inscripcion = new HashMap<>();
        inscripcion.put("numeroParticipante", numParticipante);
        inscripcion.put("dni", dni);
        inscripcion.put("nombre", nombre);
        inscripcion.put("apellido", apellido);
        inscripcion.put("edad", edad);
        inscripcion.put("celular", celular);
        inscripcion.put("numEmergencia", numEmergencia);
        inscripcion.put("grupoSanguineo", grupoSanguineo);
        inscripcion.put("categoria", categoria);
        inscripcion.put("numInscripcion", numInscripcion);
        inscripcion.put("monto", monto);
        inscripciones.add(inscripcion);



    }
    public static int calcularMonto(String categoria, int edad){
        switch (categoria){
            case "Circuito chico":
                return edad < 18 ? 1300: 1500;
            case "Circuito medio":
                return edad < 18 ? 2000: 2300;
            case "Circuito avanzado":
                return edad >= 18 ? 2800 : 0;
            default:
                return 0;

        }
    }

    public static void mostrarInscriptos(List<Map<String,Object>> inscripciones) {
        for(Map<String, Object> inscripcion: inscripciones){
            System.out.println("\nNumero de inscripcion: " + inscripcion.get("numInscripcion"));
            System.out.println("Dni: " + inscripcion.get("dni"));
            System.out.println("Nombre: " + inscripcion.get("nombre"));
            System.out.println("Apellido: " + inscripcion.get("apellido"));
            System.out.println("Edad: " + inscripcion.get("edad"));
            System.out.println("Celular: " + inscripcion.get("celular"));
            System.out.println("Numero De emergencia: " + inscripcion.get("numEmergencia"));
            System.out.println("Grupo Sanguineo: " + inscripcion.get("grupoSanguineo"));
        }
    }

    public static void desinscribirParticipante(List<Map<String, Object>> inscripciones, int numInscripcion){
        inscripciones.removeIf(inscripcion -> (int) inscripcion.get("numInscripcion") == numInscripcion);
    }

    public static int calcularRecaudacionInscripcionesPorCircuito(List<Map<String, Object>> inscripciones) {
        int total = 0;
        for (Map<String, Object> inscripcion : inscripciones) {
            total += (int) inscripcion.get("monto");
        }
        return  total;

    }

    public static void main(String[] args) {
        //Genero el diccionario de categorias y agrego su descripcion
        Map<String,String> categorias = new HashMap<>();
        categorias.put("Circuito chico", "2 km por selva y arroyos");
        categorias.put("Circuito medio", "5 km por selva, arroyos y barro");
        categorias.put("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        //Genero la lista de inscripciones para cada categoria
        List<Map<String,Object>> inscripcionesChico = new ArrayList<>();
        List<Map<String,Object>> inscripcionesMedio = new ArrayList<>();
        List<Map<String,Object>> inscripcionesAvanzado = new ArrayList<>();

        //Inscribo participantes en una categoria
        inscribirParticipante(inscripcionesChico,1,35000, "Christian", "Bravo",20,
                15000, 15000, "AB+", "Circuito chico",1);
        inscribirParticipante(inscripcionesMedio,2,45000, "Franco", "Gomez",33,
                15000, 15000, "0+", "Circuito medio",2);
        inscribirParticipante(inscripcionesAvanzado,3,55000, "Malcom", "Perez",44,
                15000, 15000, "AB+", "Circuito avanzado",3);

        //inscribo participantes en una categoria
        inscribirParticipante(inscripcionesChico,4,34000, "Christian", "Reyes",25,
                15000, 15000, "B+", "Circuito chico",4);
        inscribirParticipante(inscripcionesMedio,5,44000, "Lisandro", "Lopez",33,
                15000, 15000, "0+", "Circuito medio",5);
        inscribirParticipante(inscripcionesAvanzado,6,60000, "Mariano", "Sanchez",54,
                15000, 15000, "A+", "Circuito avanzado",6);

        //mostrar los inscriptos para cada lista
        System.out.println("\nLas inscripciones del circuito chico son: ");
        mostrarInscriptos(inscripcionesChico);
        System.out.println("\nLas inscripciones del circuito medio son: ");
        mostrarInscriptos(inscripcionesMedio);
        System.out.println("\nLas inscripciones del circuito avanzado son: ");
        mostrarInscriptos(inscripcionesAvanzado);

        //Desinscribo un participante
        desinscribirParticipante(inscripcionesChico, 1);
        //chequeamos la desinscripcion
        System.out.println("\nDespues de desinscribirse: ");
        mostrarInscriptos(inscripcionesChico);

        //Calculo los montos recaudados por las inscripciones y muestro los datos
        int totalCircuitoChico = calcularRecaudacionInscripcionesPorCircuito(inscripcionesChico);
        int totalCircuitoMedio = calcularRecaudacionInscripcionesPorCircuito(inscripcionesMedio);
        int totalCircuitoAvanzado = calcularRecaudacionInscripcionesPorCircuito(inscripcionesAvanzado);
        int totalCarrera = totalCircuitoChico + totalCircuitoAvanzado + totalCircuitoAvanzado;
        System.out.println("\nMontos recaudados: ");
        System.out.println("Circuito Chico: " + totalCircuitoChico);
        System.out.println("Circuito Medio: " + totalCircuitoMedio);
        System.out.println("Circuito Avanzado: " + totalCircuitoAvanzado);
        System.out.println("Total recaudacion carrera: " + totalCarrera);






    }
}