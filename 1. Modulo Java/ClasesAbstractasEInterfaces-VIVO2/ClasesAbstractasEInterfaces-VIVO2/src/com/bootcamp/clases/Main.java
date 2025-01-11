package com.bootcamp.clases;

public class Main {
    public static void main(String[] args) {

    LibroPdf libro = new LibroPdf(54,"Carlos Sanchez","Las aventuras de mathew","Aventura");
    Curriculum curriculum = new Curriculum("Nicolas","Fiore","12345678",23);
    Informe informe = new Informe("Lorem ipsum sit amet",4,"Nicolas Fiore","Aixa castillo");

    curriculum.agregarHabilidades("Proactivo");
    curriculum.agregarHabilidades("Organizado");

    libro.imprimir();
    curriculum.imprimir();
    informe.imprimir();
    }

}
