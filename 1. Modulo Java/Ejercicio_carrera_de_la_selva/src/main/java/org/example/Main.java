package org.example;
import java.util.*;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Map<String, Map<String, Object>> categorias = new HashMap<>();
        Map<String, Object> circuitoChico = new HashMap<>();
        circuitoChico.put("id", 1);
        circuitoChico.put("nombre", "Circuito chico");
        circuitoChico.put("descripcion", "2 km por selva y arroyos");
        categorias.put("circuito chico", circuitoChico);

        Map<String, Object> circuitoMedio = new HashMap<>();
        circuitoMedio.put("id", 2);
        circuitoMedio.put("nombre", "Circuito medio");
        circuitoMedio.put("descripcion", "5 km por selva, arroyos y barro.");
        categorias.put("circuito medio", circuitoMedio);

        Map<String, Object> circuitoAvanzado = new HashMap<>();
        circuitoAvanzado.put("id", 3);
        circuitoAvanzado.put("nombre", "Circuito avanzado");
        circuitoAvanzado.put("descripcion", "10 km por selva, arroyos, barro y escalada en piedra.");
        categorias.put("circuito avanzado", circuitoAvanzado);

        List<Map<String, Object>> inscripciones = new ArrayList<>();
        Map<String, Object> inscripcion = new HashMap<>();
        inscripcion.put("numeroInscripcion", 3);
        inscripcion.put("categoria", 1);
        inscripcion.put("dni", 2);
        inscripcion.put("nombre", "Sergio");
        inscripcion.put("apellido", "Ramirez");
        inscripcion.put("edad", 50);
        inscripcion.put("celular", "000");
        inscripcion.put("emergencia", "222");
        inscripcion.put("grupoSanguineo", "D+");
        inscripciones.add(inscripcion);

        Map<String, Object> inscripcion2 = new HashMap<>();
        inscripcion2.put("numeroInscripcion", 1);
        inscripcion2.put("categoria", 2);
        inscripcion2.put("dni", 3);
        inscripcion2.put("nombre", "Fabiana");
        inscripcion2.put("apellido", "Jimenez");
        inscripcion2.put("edad", 20);
        inscripcion2.put("celular", "222");
        inscripcion2.put("emergencia", "777");
        inscripcion2.put("grupoSanguineo", "A+");
        inscripciones.add(inscripcion2);

        Map<String, Object> inscripcion3 = new HashMap<>();
        inscripcion3.put("numeroInscripcion", 1);
        inscripcion3.put("categoria", 3);
        inscripcion3.put("dni", 1);
        inscripcion3.put("nombre", "Juan");
        inscripcion3.put("apellido", "Zaga");
        inscripcion3.put("edad", 15);
        inscripcion3.put("celular", "777");
        inscripcion3.put("emergencia", "333");
        inscripcion3.put("grupoSanguineo", "B-");
        inscripciones.add(inscripcion3);


        for (Map<String, Object> inscripcion : inscripciones) {
            System.out.println("Inscripcion: " + inscripcion.get("numeroInscripcion"));
            System.out.println("Nombre: " + inscripcion.get("nombre"));
            Object id = inscripcion.get("categoria");
            categorias.get(id.toString());
            System.out.println("Categoria: " + inscripcion.get("categoria"));
        }

    }
}