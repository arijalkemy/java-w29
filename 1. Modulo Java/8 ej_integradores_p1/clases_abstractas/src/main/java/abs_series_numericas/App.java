package abs_series_numericas;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("=======================");
        System.out.println("Serie de 2");
        SerieEntera serie = new SerieEntera(2);
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
        System.out.println("=======================");
        System.out.println("Serie de 1");
        serie = new SerieEntera(1);
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
        System.out.println("=======================");
        System.out.println("Serie de 3");
        serie = new SerieEntera(3);
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
        System.out.println(serie.valorSiguiente());
    }
}
