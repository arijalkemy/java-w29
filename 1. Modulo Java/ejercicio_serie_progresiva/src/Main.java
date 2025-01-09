import clases.SerieDouble;
import clases.SerieInteger;

public class Main {
    public static void main(String[] args) {

        System.out.println("SERIE INTEGER");
        SerieInteger serieInteger = new SerieInteger(2);

        serieInteger.setValorInicial(1);
        System.out.println(serieInteger.getSiguienteValor());
        System.out.println(serieInteger.getSiguienteValor());
        System.out.println(serieInteger.getSiguienteValor());
        serieInteger.reiniciarValores();
        System.out.println(serieInteger.getSiguienteValor());
        System.out.println(" ----- ");
        serieInteger.setValorInicial(2);
        System.out.println(serieInteger.getSiguienteValor());
        System.out.println(serieInteger.getSiguienteValor());
        System.out.println(serieInteger.getSiguienteValor());
        serieInteger.reiniciarValores();
        System.out.println(serieInteger.getSiguienteValor());
        System.out.println(" ----- ");
        serieInteger.setValorInicial(3);
        System.out.println(serieInteger.getSiguienteValor());
        System.out.println(serieInteger.getSiguienteValor());
        System.out.println(serieInteger.getSiguienteValor());
        serieInteger.reiniciarValores();
        System.out.println(serieInteger.getSiguienteValor());

        System.out.println("SERIE DOUBLE");
        SerieDouble serieDouble = new SerieDouble(2.0);

        serieDouble.setValorInicial(1.0);
        System.out.println(serieDouble.getSiguienteValor());
        System.out.println(serieDouble.getSiguienteValor());
        System.out.println(serieDouble.getSiguienteValor());
        serieDouble.reiniciarValores();
        System.out.println(serieDouble.getSiguienteValor());
        System.out.println(" ----- ");
        serieDouble.setValorInicial(2.0);
        System.out.println(serieDouble.getSiguienteValor());
        System.out.println(serieDouble.getSiguienteValor());
        System.out.println(serieDouble.getSiguienteValor());
        serieDouble.reiniciarValores();
        System.out.println(serieDouble.getSiguienteValor());
        System.out.println(" ----- ");
        serieDouble.setValorInicial(3.0);
        System.out.println(serieDouble.getSiguienteValor());
        System.out.println(serieDouble.getSiguienteValor());
        System.out.println(serieDouble.getSiguienteValor());
        serieDouble.reiniciarValores();
        System.out.println(serieDouble.getSiguienteValor());
        System.out.println(" ----- ");



    }
}
