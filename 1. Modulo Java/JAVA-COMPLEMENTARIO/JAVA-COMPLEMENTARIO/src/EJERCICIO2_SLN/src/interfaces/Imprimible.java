package src.interfaces;

import src.clases.Documento;

public interface Imprimible {

    static void imprimirDocumento(Documento documento){
        documento.imprimir();
    };

    void imprimirTipoDoc();
}
