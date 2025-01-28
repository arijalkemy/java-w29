package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Juan Perez", new String[]{"Java", "C++", "Python"});
        LibroPDF libroPDF = new LibroPDF("Gabriel Garcia Marquez", "Cien años de soledad", "Novela", 400);
        Informe informe = new Informe("Informe anual de resultados", "Ana García", "Luis Martínez", 20);

        imprimirDocumento(curriculum);
        imprimirDocumento(libroPDF);
        imprimirDocumento(informe);
    }

    public static void imprimirDocumento(Imprimible documento) {
        documento.imprimir();
        System.out.println("-----------------------------------");
    }
}
