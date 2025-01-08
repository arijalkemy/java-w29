import com.bootcamp.Categoria;
import com.bootcamp.Inscripcion;
import com.bootcamp.Participante;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // A - Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos.

        Categoria categoriaChico = new Categoria(Categoria.CIRCUITO_CHICO);
        Categoria categoriaMedio = new Categoria(Categoria.CIRCUITO_MEDIO);
        Categoria categoriaAvanzado = new Categoria(Categoria.CIRCUITO_AVANZADO);

        determinarCircuito(categoriaChico);
        determinarCircuito(categoriaMedio);
        determinarCircuito(categoriaAvanzado);

        // B - Crear un nuevo participante e inscribirlo en una categoría

        Participante participante1 = new Participante(1234, "Julian", "Castro", 28, 39347169, 1134499049, 1144436354, "A-");
        Inscripcion inscripcion1 = new Inscripcion(0001);
        inscribirParticipante(inscripcion1, participante1, categoriaMedio);

        // C - Calcular el monto de inscripción que deberá abonar (Por ejemplo: si el participante se inscribe a la categoría Circuito chico y tiene 21 años, el monto a abonar es de $1500).
        System.out.println("El monto a abonar de " + participante1.getNombre() + " " + participante1.getApellido() + " es de: " + inscripcion1.getMontoAAbonar() + "$");

        // D - Inscribir al azar algunos participantes en diferentes categorías (al menos uno en cada una).
        Participante participante2 = new Participante(5678, "Laura", "Pérez", 34, 40234567, 1122334455, 1155667788, "O+");
        Participante participante3 = new Participante(9101, "Carlos", "Gomez", 40, 40987654, 1198877666, 1166778899, "B+");
        Participante participante4 = new Participante(1122, "Ana", "Ramírez", 15, 40321567, 1168992233, 1133445566, "AB+");
        Participante participante5 = new Participante(3344, "Miguel", "López", 32, 40456789, 1199887766, 1177888999, "A+");
        Participante participante6 = new Participante(5566, "Sofia", "Martínez", 3, 40345678, 1188776655, 1188999000, "O-");
        Inscripcion inscripcion2 = new Inscripcion(0002);
        Inscripcion inscripcion3 = new Inscripcion(0003);
        Inscripcion inscripcion4 = new Inscripcion(0004);
        Inscripcion inscripcion5 = new Inscripcion(0005);
        Inscripcion inscripcion6 = new Inscripcion(0006);
        inscribirParticipante(inscripcion6, participante2, categoriaAvanzado);
        inscribirParticipante(inscripcion2, participante3, categoriaAvanzado);
        inscribirParticipante(inscripcion3, participante4, categoriaChico);
        inscribirParticipante(inscripcion4, participante5, categoriaChico);
        inscribirParticipante(inscripcion5, participante6, categoriaMedio);

        // E - Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
        List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();
        inscripciones.add(inscripcion1);
        inscripciones.add(inscripcion2);
        inscripciones.add(inscripcion3);
        inscripciones.add(inscripcion4);
        inscripciones.add(inscripcion5);
        inscripciones.add(inscripcion6);

        Map<Integer, Categoria> categoriasChico = new HashMap<Integer, Categoria>();
        for (Inscripcion i : inscripciones) {
            if (Categoria.CIRCUITO_CHICO.equals(i.getCategoria().getCircuito())) {
                categoriasChico.put(i.getNumero(), i.getCategoria());
            }
        }
        for (Map.Entry<Integer, Categoria> c : categoriasChico.entrySet()) {
            System.out.println("Numero de inscripcion: " + c.getKey());
            System.out.println("Categoria: " + c.getValue());
        }

        // F - Desinscribir a un participante. Mostrar como queda la lista de inscriptos en la categoría donde se encontraba.
        System.out.println("Despues de eliminar: ");
        inscripciones.remove(inscripcion3);
        for (Inscripcion i : inscripciones) {
            if (Categoria.CIRCUITO_CHICO.equals(i.getCategoria().getCircuito())) {
                System.out.println(i.toString());
            }
        }

        // G - Calcular el monto total recaudado por cada categoría y el total de toda la carrera incluyendo todas las categorías.
        Double montoChico = 0.0;
        Double montoMedio = 0.0;
        Double montoAvanzado = 0.0;
        Double montoTotal = 0.0;

        for (Inscripcion i : inscripciones) {
            if (Categoria.CIRCUITO_CHICO.equals(i.getCategoria().getCircuito())) {
                montoChico += i.getMontoAAbonar();
            } else if (Categoria.CIRCUITO_MEDIO.equals(i.getCategoria().getCircuito())) {
                montoMedio += i.getMontoAAbonar();
            } else if (Categoria.CIRCUITO_AVANZADO.equals(i.getCategoria().getCircuito())) {
                montoAvanzado += i.getMontoAAbonar();
            }
            montoTotal += i.getMontoAAbonar();
        }

        System.out.println("Monto total recaudado por categoría:");
        System.out.println("Categoría Chico: " + montoChico);
        System.out.println("Categoría Medio: " + montoMedio);
        System.out.println("Categoría Avanzado: " + montoAvanzado);
        System.out.println("Monto total de toda la carrera: " + montoTotal);
    }


    public static void inscribirParticipante(Inscripcion inscripcion, Participante participante, Categoria categoria) {
        inscripcion.setParticipante(participante);
        inscripcion.setCategoria(categoria);
        if (participante != null && categoria != null) {
            if (Categoria.CIRCUITO_CHICO.equals(categoria.getCircuito())) {
                if (participante.getEdad() < 18) {
                    inscripcion.setMontoAAbonar(1300.0);
                } else {
                    inscripcion.setMontoAAbonar(1500.0);
                }
            } else if (Categoria.CIRCUITO_MEDIO.equals(categoria.getCircuito())) {
                if (participante.getEdad() < 18) {
                    inscripcion.setMontoAAbonar(2000.0);
                } else {
                    inscripcion.setMontoAAbonar(2300.0);
                }
            } else if (Categoria.CIRCUITO_AVANZADO.equals(categoria.getCircuito())) {
                if (participante.getEdad() < 18) {
                    throw new IllegalArgumentException("No se admiten participantes menores de 18 en esta categoria");
                } else {
                    inscripcion.setMontoAAbonar(2800.0);
                }
            } else {
                throw new IllegalArgumentException("Error al inscribir participante");
            }
            categoria.getParticipantes().add(participante);
        }
    }

    public static void determinarCircuito(Categoria categoria) {
        if (Categoria.CIRCUITO_CHICO.equals(categoria.getCircuito())) {
            categoria.setKm(2.0f);
            categoria.setDescripcion("por selva y arroyos.");
        } else if (Categoria.CIRCUITO_MEDIO.equals(categoria.getCircuito())) {
            categoria.setKm(5.0f);
            categoria.setDescripcion("por selva, arroyos y barro.");
        } else if (Categoria.CIRCUITO_AVANZADO.equals(categoria.getCircuito())) {
            categoria.setKm(10.0f);
            categoria.setDescripcion("por selva, arroyos, barro y escalada en piedra.");
        } else {
            throw new IllegalArgumentException("Categoria incorrecta. solo se admite CHICO, MEDIO, AVANZADO");
        }
    }


}