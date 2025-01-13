package ej2;

public abstract class Documento implements Imprimible {
    protected String contenido;

    public Documento(String contenido) {
        this.contenido = contenido;
    }
}
