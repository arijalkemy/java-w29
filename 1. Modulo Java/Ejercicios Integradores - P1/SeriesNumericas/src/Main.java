import Serie.SeriesDouble;
import Serie.SeriesEntero;

public class Main {
    public static void main(String[] args) {
        SeriesEntero series = new SeriesEntero();
        series.establecer(0);
        System.out.println("Siguiente de serie Integer: " + series.siguiente());
        series.reiniciar();
        System.out.println("Siguiente de serie Integer (Reiniciar): " + series.siguiente());

        SeriesDouble seriesDouble = new SeriesDouble();
        seriesDouble.establecer(0.0);
        System.out.println("Siguiente de serie Double: " + seriesDouble.siguiente());
        seriesDouble.reiniciar();
        System.out.println("Siguiente de serie Double (Reiniciar): " + seriesDouble.siguiente());
    }
}