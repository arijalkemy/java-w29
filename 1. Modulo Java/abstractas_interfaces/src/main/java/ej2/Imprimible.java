package ej2;

public interface Imprimible {
    static void imprimir(Documento doc) {
        System.out.println("Imprimiendo... " + doc.toString());
    }
}
