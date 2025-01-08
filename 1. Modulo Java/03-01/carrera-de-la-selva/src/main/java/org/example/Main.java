package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public final static Double[][] MONTOS = new Double[][]{
            {1300.00, 1500.00},
            {2000.00, 2300.00},
            {2800.00}
    };

    public static void main(String[] args) {
        // Categorías
        Map<String, Object> categoria1 = crearCategoria(0, "Circuito chico", "2 km por selva y arroyos.");
        Map<String, Object> categoria2 = crearCategoria(1, "Circuito medio", "5 km por selva, arroyos y barro.");
        Map<String, Object> categoria3 = crearCategoria(2, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");
        // List<Map<String, Object>> categorias = new ArrayList<>() {{add(categoria1); add(categoria2); add(categoria3);}};

        // Participantes
        Map<String, Object> participante1 = crearParticipante(0, "43571203", "Martín", "Pombo", 18, "1122766971", "911", "0+");
        Map<String, Object> participante2 = crearParticipante(1, "21980074", "Mariela", "Allegri", 54, "1159628594", "911", "0+");
        Map<String, Object> participante3 = crearParticipante(2, "21493319", "Diego", "Pombo", 16, "1123435465", "911", "A-");
        Map<String, Object> participante4 = crearParticipante(3, "46026532", "Marco", "Dizeo", 17, "1123435465", "911", "AB-");
        Map<String, Object> participante5 = crearParticipante(4, "46026532", "Sofia", "Dizeo", 21, "1324344556", "911", "B-");
        // List<Map<String, Object>> participantes = new ArrayList<>() {{add(participante1); add(participante2); add(participante3);}};

        // Inscripciones
        List<Map<String, Object>> inscripciones = new ArrayList<>();

        System.out.println("----------------- INSCRIPCIONES -----------------");
        inscribirParticipante(participante1, categoria2, inscripciones);
        inscribirParticipante(participante2, categoria1, inscripciones);
        inscribirParticipante(participante3, categoria3, inscripciones);
        inscribirParticipante(participante1, categoria3, inscripciones);
        inscribirParticipante(participante4, categoria1, inscripciones);
        inscribirParticipante(participante5, categoria3, inscripciones);
        System.out.println();

        int categoriaAMostrar = 0;
        System.out.printf("----------------- INSCRIPCIONES DE LA CATEGORIA %s -----------------\n", categoriaAMostrar);
        mostrarInscritposDeCategoria(categoriaAMostrar, inscripciones);

        Map<String, Object> participanteADesinscribir = participante2;
        System.out.printf("----------------- DESINSCRIBIR AL PARTICIPANTE %s -----------------\n", participanteADesinscribir.get("id"));
        desincribirParticipante(participanteADesinscribir, inscripciones);

        System.out.println("----------------- CALCULAR TOTAL RECAUDAD -----------------");
        calcularTotalRecaudado(inscripciones);
    }




    private static Map<String, Object> crearCategoria(int id, String nombre, String descripcion) {
        return Map.of(
                "id", id,
                "nombre", nombre,
                "descripcion", descripcion
        );
    }
    private static Map<String, Object> crearParticipante(int id, String dni, String nombre, String apellido, int edad, String telefono, String numEmergencia, String grupoSanguineo) {
        return Map.of(
                "id",  id,
                "dni",  dni,
                "nombre",  nombre,
                "apellido",  apellido,
                "edad",  edad,
                "telefono",  telefono,
                "numEmergencia",  numEmergencia,
                "grupoSanguineo",  grupoSanguineo
        );
    }

    private static Map<String, Object> crearInscripcion(int numInscripcion, Map<String, Object> participante, Map<String, Object> categoria, double montoInscripcion) {
        return Map.of(
                "numInscripcion", numInscripcion,
                "idCategoria", categoria.get("id"),
                "idParticipante", participante.get("id"),
                "monto", montoInscripcion
        );
    }

    public static void inscribirParticipante(Map<String, Object> participante, Map<String, Object> categoria, List<Map<String, Object>> inscripciones) {
        if(sePuedeInscribir(participante, categoria, inscripciones)) {
            int numInscripcion = (!inscripciones.isEmpty()) ? inscripciones.size(): 0;
            double montoInscripcion = getMontoInscripcion(categoria, participante);

            Map<String, Object> inscripcion = crearInscripcion(numInscripcion, participante, categoria, montoInscripcion);

            inscripciones.add(inscripcion);
        }
     }

    private static boolean sePuedeInscribir(Map<String, Object> participante, Map<String, Object> categoria, List<Map<String, Object>> inscripciones) {
        boolean participanteExiste;
        boolean sePuedeInscribir = true;

        if ((Integer) categoria.get("id") == 2 && (Integer) participante.get("edad") < 18) {
            System.out.println("Los menores de 18 no pueden inscribirse al " + categoria.get("nombre"));
            sePuedeInscribir = false;
        } else {
            if (!inscripciones.isEmpty()) {
                for (Map<String, Object> e : inscripciones) {
                    participanteExiste = participante.get("id") == e.get("idParticipante");
                    if (participanteExiste) {
                        int idCategoria = (Integer)e.get("idCategoria");
                        System.out.printf("No se puede inscribirse a %s a %s porque ya está inscripto en algún circuito\n", participante.get("nombre"), categoria.get("nombre"));
                        sePuedeInscribir = false;
                        break;
                    }
                }
            }
        }
        return sePuedeInscribir;
    }

    private static void mostrarInscritposDeCategoria(int idCategoria, List<Map<String, Object>> inscripciones) {
        boolean hayInscriptos = false;
        for (Map<String, Object> inscripcion : inscripciones) {
            if(inscripcion.get("idCategoria").equals(idCategoria)) {
                hayInscriptos = true;
                System.out.println(inscripcion);
            }
        }
        if (!hayInscriptos) {
            System.out.println("No hay inscriptos en la categoria " + idCategoria);
        }
    }

    private static void desincribirParticipante(Map<String, Object> participanteADesinscribir, List<Map<String, Object>> inscripciones) {
        boolean participanteEliminado = false;
        int categoriaAMostrar = 0;
        for (Map<String, Object> inscripcion : inscripciones) {
            if (participanteADesinscribir.get("id").equals(inscripcion.get("idParticipante"))) {
                categoriaAMostrar = (int) inscripcion.get("idCategoria");
                participanteEliminado = inscripciones.remove(inscripcion);
                break;
            }
        }
        if (participanteEliminado) {
            mostrarInscritposDeCategoria(categoriaAMostrar, inscripciones);
        } else {
            System.out.println("El participante no se encuentra inscripto");
        }
    }

    private static double getMontoInscripcion(Map<String, Object> categoria, Map<String, Object> participante) {
        double monto = 0;
        switch ((Integer)categoria.get("id")) {
            case 0 -> monto = ((Integer)participante.get("edad") < 18) ? MONTOS[0][0] : MONTOS[0][1];
            case 1 -> monto = ((Integer)participante.get("edad") < 18) ? MONTOS[1][0] : MONTOS[1][1];
            case 2 -> monto = MONTOS[2][0];
        }
        System.out.println("El monto a abonar es de " + monto);
        return monto;
    }

    private static void calcularTotalRecaudado(List<Map<String, Object>> inscripciones) {
        double total = 0;
        double circuitoChico = 0;
        double circuitoMedio = 0;
        double circuitoAvanzado = 0;
        for (Map<String, Object> inscripcion : inscripciones) {
            switch ((int)inscripcion.get("idCategoria")) {
                case 0 -> circuitoChico = (Double) inscripcion.get("monto");
                case 1 -> circuitoMedio = (Double) inscripcion.get("monto");
                case 2 -> circuitoAvanzado = (Double) inscripcion.get("monto");
            }
        }
        System.out.println("El total recaudado por el Circuito chico es: " + circuitoChico);
        System.out.println("El total recaudado por el Circuito medio es: " + circuitoMedio);
        System.out.println("El total recaudado por el Circuito avanzado es: " + circuitoAvanzado);
        System.out.println("El total recaudado por todos los circuitos es de: " + (circuitoChico + circuitoMedio + circuitoAvanzado));
    }
}