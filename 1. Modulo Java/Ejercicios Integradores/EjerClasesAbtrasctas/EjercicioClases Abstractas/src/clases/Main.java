package clases;

public class Main {
    public static void main(String[] args) {

        SerieProgresivaDos serieDos = new SerieProgresivaDos();

        for (int i = 0; i < 5; i++){
            System.out.println(serieDos.valorSiguiente(2));
        }
        serieDos.establecerValorInicialSerie(2);
        System.out.println(serieDos.valorActual);


        SerieProgresivaTres serieTres = new SerieProgresivaTres();
        for (int i = 0; i <5; i++){
            System.out.println(serieTres.valorSiguiente(3));
        }
        serieTres.establecerValorInicialSerie(3);
        System.out.println(serieTres.valorActual);
    }
}
