package org.example.documentos;

public class Curriculum extends Documento implements Imprimible{
    private Persona persona;

    public Curriculum(Persona persona, Integer cantidadDePaginas) {
        super(cantidadDePaginas);
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona=" + persona +
                "cantidadDePaginas=" + super.getCantidadDePaginas() +
                '}';
    }

    @Override
    public void imprimirDocumento() {
        System.out.println("Imprimiendo curriculum...\n" + this.toString() + "\n");
    }

}
