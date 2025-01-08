package ejercicio2.interfaces;

import ejercicio2.clases.Documento;

public interface Imprimible {

    static void imprimirDocumento(Documento documento) {
        documento.imprimir();
    }
}
