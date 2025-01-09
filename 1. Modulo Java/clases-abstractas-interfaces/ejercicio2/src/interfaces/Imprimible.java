package interfaces;

import clases.Documento;

public interface Imprimible {

    static void imprimirDocumento(Documento documento) {
        documento.imprimir();
    }
}
