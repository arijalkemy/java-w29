package procesador;

public interface Imprimible {
    void imprimir();

    static void imprimirDocumento(Imprimible documento) {
        documento.imprimir();
    }
}
