package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final String CHICO = "Chico";
    public static final String MEDIO = "Medio";
    public static final String AVANZADO = "Avanzado";

    public static void main(String[] args) {
        Map<String, ArrayList> categoria = generarCategorias();

        Map<String, Object> participante1 = generarParticipante(12345345, "111003321", "Daniel",
                "Gimenez", 20, "555-1234", "555-5678", "O+");

        Map<String, Object> participante2 = generarParticipante(12345375, "111903321", "Juan",
                "Rodriguez", 17, "555-1234", "555-5678", "AB+");

        Map<String, Object> participante3 = generarParticipante(12345390, "123321908", "Lucia",
        "Badia", 56, "555-1234", "555-5678", "A-");

        ArrayList<Map> inscripcionesChico = new ArrayList<>();
        inscribirParticipante(inscripcionesChico, participante1, CHICO);

        ArrayList<Map> inscripcionesMedio = new ArrayList<>();
        inscribirParticipante(inscripcionesMedio, participante2, MEDIO);

        ArrayList<Map> inscripcionesAvanzado = new ArrayList<>();
        inscribirParticipante(inscripcionesAvanzado, participante3, AVANZADO);

        mostrarParticipantesInscriptos(inscripcionesChico, CHICO);

        desinscribirParticipante(inscripcionesChico, (int) participante1.get("Número de Participante"));

        mostrarParticipantesInscriptos(inscripcionesChico, CHICO);

        Integer montoTotalChico = calcularMontoPorCategoria(inscripcionesChico);
        System.out.println("El monto total chico recaudado fue de: " + montoTotalChico);

        Integer montoTotalMedio = calcularMontoPorCategoria(inscripcionesMedio);
        System.out.println("El monto total medio recaudado fue de: " + montoTotalMedio);

        Integer montoTotalAvanzado = calcularMontoPorCategoria(inscripcionesAvanzado);
        System.out.println("El monto total avanzado recaudado fue de: " + montoTotalAvanzado);

        Integer montoTotal = montoTotalChico + montoTotalMedio + montoTotalAvanzado;

        System.out.println("El monto total recaudado fue de: " + montoTotal);

    }

    public static Map<String, ArrayList> generarCategorias(){
        Map<String, ArrayList> categorias = new HashMap<>();
        ArrayList<String> chico = crearCategoria("Circuito Chico", "Dos Kilometros por selva y arroyos");
        categorias.put(CHICO, chico);

        ArrayList<String> medio = crearCategoria("Circuito Medio", "5 Kilometros por selva, arroyos y barro");
        categorias.put(MEDIO, medio);

        ArrayList<String> avanzado = crearCategoria("Circuito Avanzado", "10 km por selva, arroyos, barro y escalada en piedra");
        categorias.put(AVANZADO, avanzado);

        return categorias;
    }

    public static ArrayList<String> crearCategoria(String titulo, String descripcion){
        ArrayList<String> categoria = new ArrayList<>();
        categoria.add(titulo);
        categoria.add(descripcion);
        return categoria;
    }

    public static Map<String, Object> generarParticipante(Integer numeroParticipante, String dni,
                                                          String nombre, String apellido, Integer edad, String celular,
                                                          String numeroEmergencia, String grupoSanguineo){
        Map<String, Object> participante = new HashMap<>();
        participante.put("Número de Participante", numeroParticipante);
        participante.put("DNI", dni);
        participante.put("Nombre", nombre);
        participante.put("Apellido", apellido);
        participante.put("Edad", edad);
        participante.put("Celular", celular);
        participante.put("Número de Emergencia", numeroEmergencia);
        participante.put("Grupo Sanguíneo", grupoSanguineo);
        return participante;
    }

    public static void inscribirParticipante(ArrayList<Map> inscripciones, Map participante, String categoria){
        inscripciones.add(participante);
        participante.put("Monto", calcularMonto(categoria, participante));
        participante.put("Inscripcion", Math.random());

    }

    public static int calcularMonto(String categoria, Map participante) {
        Integer edad = (Integer) participante.get("Edad");
        switch (categoria) {
            case CHICO:
                return edad < 18 ? 1300 : 1500;
            case MEDIO:
                return edad < 18 ? 2000 : 2300;
            case AVANZADO:
                return edad >= 18 ? 2800 : -1;
            default:
                return -1;
        }
    }

    public static void mostrarParticipantesInscriptos(ArrayList<Map> inscripciones, String categoria){
        System.out.println("-----------------------------");

        for(Map inscripcion : inscripciones){
            System.out.println("Categoria: " + categoria);
            mostrarParticipante(inscripcion);
        }

        if(inscripciones.isEmpty()){
            System.out.println("No hay participantes inscriptos en la categoria: " + categoria);
        }
    }

    public static void mostrarParticipante(Map<String, Object> participante){
        for (Map.Entry<String, Object> entry : participante.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + ": " + value);
        }
    }

    public static void desinscribirParticipante(ArrayList<Map> inscripciones, int numeroParticipante){
        inscripciones.removeIf(participante ->((int) participante.get("Número de Participante")) == numeroParticipante);
    }

    public static Integer calcularMontoPorCategoria(ArrayList<Map> inscripciones){
        Integer monto = 0;
        for(Map<String, Object> participante : inscripciones){
            monto += (Integer) participante.get("Monto");
        }
        return monto;
    }
}
