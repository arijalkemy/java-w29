import Interfaces.Imprimir;
import Models.Curriculum;
import Models.Informe;
import Models.Libro;

public class Main {

    public static void main(String[] args) {
        // Crear un Curriculum
        String[] habilidades = {"Java", "SQL", "Gestión de proyectos"};
        Curriculum curriculum = new Curriculum("Juan", "Pérez", "juan.perez@ejemplo.com", "123456789", habilidades);

        // Crear un Libro
        Libro libro = new Libro("Gabriel García Márquez", "Cien años de soledad", "Realismo mágico", "lorem ipsum texto de prueba", 250);

        // Crear un Informe
        Informe informe = new Informe("Informe sobre el estado del proyecto", 10, "María López", "Pedro Gómez");

        // Array de documentos
        Imprimir[] documentos = {curriculum, libro, informe};

        // Imprimir información de cada documento
        for (Imprimir documento : documentos) {
            System.out.println();
            System.out.println("Tipo de Documento: " + documento.tipoDocumento());
            documento.imprimir();
            System.out.println(); // Línea en blanco para mejorar la legibilidad
            System.out.println("-----------------------------------------------"); // Línea en blanco para mejorar la legibilidad
        }
    }
}