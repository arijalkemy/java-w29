package org;

public class Main {
    public static void main(String[] args) {
        // Crear las categorías
        Categoria chico = new Categoria("1", "Circuito chico", "2 km por selva y arroyos");
        Categoria medio = new Categoria("2", "Circuito medio", "5 km por selva, arroyos y barro");
        Categoria avanzado = new Categoria("3", "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        // Crear participantes
        Participante p1 = new Participante(1, "12345678", "Juan", "Perez", 21, "123-456", "789-012", "O+");
        Participante p2 = new Participante(2, "87654321", "Maria", "Gomez", 16, "456-789", "012-345", "A-");
        Participante p3 = new Participante(3, "11112222", "Carlos", "Lopez", 30, "321-654", "987-654", "B+");

        // Inscripciones
        Inscripcion ins1 = new Inscripcion(1, chico, p1);
        chico.inscribir(ins1);

        Inscripcion ins2 = new Inscripcion(2, medio, p2);
        medio.inscribir(ins2);

        Inscripcion ins3 = new Inscripcion(3, avanzado, p3);
        avanzado.inscribir(ins3);

        // Mostrar inscripciones por categoría
        mostrarInscripciones(chico);
        mostrarInscripciones(medio);
        mostrarInscripciones(avanzado);

        // Desinscribir un participante
        chico.desinscribir(1);
        System.out.println("\nTras desinscribir al participante de Circuito chico:");
        mostrarInscripciones(chico);

        // Calcular recaudaciones
        int recaudacionChico = chico.calcularRecaudacionTotal();
        int recaudacionMedio = medio.calcularRecaudacionTotal();
        int recaudacionAvanzado = avanzado.calcularRecaudacionTotal();

        System.out.println("\nRecaudaciones:");
        System.out.println("Circuito chico: $" + recaudacionChico);
        System.out.println("Circuito medio: $" + recaudacionMedio);
        System.out.println("Circuito avanzado: $" + recaudacionAvanzado);
        System.out.println("Total: $" + (recaudacionChico + recaudacionMedio + recaudacionAvanzado));
    }

    private static void mostrarInscripciones(Categoria categoria) {
        System.out.println("\nInscripciones en " + categoria.getNombre() + ":");
        for (Inscripcion inscripcion : categoria.getInscripciones()) {
            System.out.println(inscripcion);
        }
    }

}