import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Imprimible curriculum = new Curriculum("Persona 1", 20, List.of("hab 1", "hab 2"));
        curriculum.Imprimir();
        Imprimible informe = new Informe("Persona 2", "Persona 3", 5, "Lorem ipsum");
        informe.Imprimir();
        Imprimible libro = new LibroPDF(200, "Persona 4", "Titulo del libro", "Terror");
        libro.Imprimir();
    }
}
