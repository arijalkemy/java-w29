public class Escenario {
    public static void main(String[] args) {

        Curriculum cv = new Curriculum("Lucas", "Quintana", 25, "Programar, tocar guitarra");
        Pdf pdf = new Pdf(34,"Lucas","El hombre de la bolsa", "terror");
        Informe informe = new Informe(332322,"lucas","pedro",12);

        Imprimible.imprimir(informe);
        Imprimible.imprimir(cv);
        Imprimible.imprimir(pdf);

    }
}
