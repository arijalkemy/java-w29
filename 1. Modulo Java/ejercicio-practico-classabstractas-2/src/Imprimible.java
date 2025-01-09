public interface Imprimible {

    static void imprimir(Imprimible documento) {
        documento.imprimirDoc();
    }

    public void imprimirDoc();
}
