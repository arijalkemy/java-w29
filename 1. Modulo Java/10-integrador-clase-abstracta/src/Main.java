import prototipo.Serie;
import prototipo.SerieConstante;
import prototipo.SerieMultiplicativa;

public class Main {
    public static void main(String[] args) {
        Serie<Integer> serieIncremento = new SerieConstante(2, 2);
        System.out.println("Serie de incremento constante:");
        System.out.println(serieIncremento.devolverSiguienteValor());
        System.out.println(serieIncremento.devolverSiguienteValor());
        System.out.println(serieIncremento.devolverSiguienteValor());

        serieIncremento.establecerValorInicial(1);
        System.out.println("\nSerie después de establecer un nuevo valor inicial:");
        System.out.println(serieIncremento.devolverSiguienteValor());
        System.out.println(serieIncremento.devolverSiguienteValor());

        Serie<Integer> serieMultiplicativa = new SerieMultiplicativa(3, 3);
        System.out.println("\nSerie multiplicativa:");
        System.out.println(serieMultiplicativa.devolverSiguienteValor());
        System.out.println(serieMultiplicativa.devolverSiguienteValor());
        System.out.println(serieMultiplicativa.devolverSiguienteValor());

        serieMultiplicativa.reiniciarSerie();
        System.out.println("\nSerie después de reiniciar:");
        System.out.println(serieMultiplicativa.devolverSiguienteValor());
    }
}