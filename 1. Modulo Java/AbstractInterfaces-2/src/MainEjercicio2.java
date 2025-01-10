import java.util.Arrays;

public class MainEjercicio2 {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Juan", 24, Arrays.asList("Java", "Spring", "SQL"));
        libroPdf libroPDF = new libroPdf(10, "Cien años de soledad", "Ficción", "Terror");
        Informe informe = new Informe("Este es un informe de prueba.", 10, "Ana", "Luis");

        Impresora.imprimir(curriculum);
        Impresora.imprimir(libroPDF);
        Impresora.imprimir(informe);
    }
}
