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

        LibroPDF libroPDF = new LibroPDF(120,"Infantil","Rafael Pombo","El principito");
        imprimirDocumento(libroPDF);

        Informe informe = new Informe("Quimica","Isaac Newton","Platon",56);
        imprimirDocumento(informe);

    }
}
