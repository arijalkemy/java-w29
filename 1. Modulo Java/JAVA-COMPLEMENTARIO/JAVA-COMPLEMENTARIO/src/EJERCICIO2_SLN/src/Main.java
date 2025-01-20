package src;


import src.clases.Curriculum;
import src.clases.Informe;
import src.clases.LibroPDF;
import src.interfaces.Imprimible;

public class Main {
    public static void main(String[] args) {
        LibroPDF libro = new LibroPDF("Aventura",54,"Carlos Sanchez","Las aventuras de mathew");
        Curriculum curriculum = new Curriculum("Jose","Gutierrez","12345678",21);
        Informe informe = new Informe("Lorem ipsum sit amet",4,"Carlos Sanchez","Omar Rodriguez");

        curriculum.agregarHabilidad("Proactivo");
        curriculum.agregarHabilidad("Responsable");
        curriculum.agregarHabilidad("Creativo");
        curriculum.agregarHabilidad("Organizado");

        Imprimible.imprimirDocumento(curriculum);
        Imprimible.imprimirDocumento(libro);
        Imprimible.imprimirDocumento(informe);


    }
}
