import classes.Curriculum;
import classes.PDFBook;
import classes.Person;
import classes.Report;
import interfaces.Printable;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person bob = new Person("Bob", 12345678);
        List<String> bobsAbilities = new ArrayList<>(List.of("trabajador", "puntual", "responsable"));
        Curriculum curriculum = new Curriculum(bob, bobsAbilities);

        PDFBook pdfBook = new PDFBook("Hobbit", "Tolkien", "Fantasy", 500);

        Report report = new Report("This is a very long report.", 1, "H. Simpson", "M. Burns");

        Printable.print(curriculum);
        Printable.print(pdfBook);
        Printable.print(report);
    }
}
