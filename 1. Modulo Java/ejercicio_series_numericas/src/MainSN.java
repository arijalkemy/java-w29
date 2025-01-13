public class MainSN {
    public static void main(String[] args) {
        SerieInteger serieIntegerDe1 = new SerieInteger(1);
        serieIntegerDe1.mostrarSerie(4);

        SerieInteger serieIntegerDe3 = new SerieInteger(3);
        serieIntegerDe3.mostrarSerie(4);

        SerieDouble serieDoubleDe2 = new SerieDouble(2.00);
        serieDoubleDe2.mostrarSerie(4);

        SerieDouble serieDoubleDeUnMedio = new SerieDouble(1.50);
        serieDoubleDeUnMedio.mostrarSerie(4);

        SerieDouble serieDoubleDeCasiUno = new SerieDouble(1.00000000000002);
        serieDoubleDeCasiUno.mostrarSerie(4);
    }
}
