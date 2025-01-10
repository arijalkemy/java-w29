

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Erik Calvillo",new String [] {"Java","SQL","Spring"});
        LibroPdf libroPdf = new LibroPdf(200,"Nicholas Spark","El guardian","Novela");
        Informe informe = new Informe("Ejemplo de informe",15,"Paulina Garcia","Erik Calvillo");

        imprimirDocumento(curriculum);
        imprimirDocumento(libroPdf);
        imprimirDocumento(informe);
    }

    public static void imprimirDocumento(Imprimir documento) {
        documento.imprimir();
    }
}