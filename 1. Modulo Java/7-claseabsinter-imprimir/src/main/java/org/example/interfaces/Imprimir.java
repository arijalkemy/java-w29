package org.example.interfaces;

import org.example.clases.Documento;

public interface Imprimir {
    public static void imprimirDocumento(Documento doc) { doc.imprimir();}
    public  void imprimirTipoDoc();
}
