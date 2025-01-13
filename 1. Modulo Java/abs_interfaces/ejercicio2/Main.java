package ejercicio2;

import java.util.List;

public class Main {

    public static void imprimirDocumento(Imprimible imprimir){
        imprimir.imprimir();

    }

    public static void main(String[] args) {
        //Crear los objetos
        Curriculum curriculum1 = new Curriculum("Silvia", 28, List.of("Java", "Python"));
        imprimirDocumento(curriculum1);

        Informe informe = new Informe("esto es un informe", "Camilo", "Juan", 20);
        imprimirDocumento(informe);

        LibroPDF libroPDF = new LibroPDF(20, "Fantasia", "Camilo", "Harry Potter");
        imprimirDocumento(libroPDF);
    }
}
