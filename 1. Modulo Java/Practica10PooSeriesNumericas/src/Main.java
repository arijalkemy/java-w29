import models.Clase1;
import models.Clase2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------- INICIANDO PROGRAMA ----------");

        Clase1 clase1 = new Clase1();
        Clase2 clase2 = new Clase2();
        List<Integer> serieClase1 = new ArrayList<>();
        List<Integer> serieClase2 = new ArrayList<>();

        int initialSerieClase1 = clase1.valorInicialSerie(2);
        int valorSiguienteSerie1 = 0;
        for (int i = 0; i < 10; i++) {
             valorSiguienteSerie1 += clase1.valorSiguiente(initialSerieClase1);
            serieClase1.add(valorSiguienteSerie1);
            i++;
        }

        int initialSerieClase2 = clase2.valorInicialSerie(3);
        int valorSiguienteSerie2 = 0;
        for (int i = 0; i < 10; i++) {
            valorSiguienteSerie2 += clase2.valorSiguiente(initialSerieClase2);
            serieClase2.add(valorSiguienteSerie2);
            i++;
        }

        System.out.println("Lista de serie de clase1 es:");
        System.out.println(clase1.generarSerie((ArrayList) serieClase1));
        System.out.println();
        System.out.println("------------------------------------");
        System.out.println("Lista de serie de clase2 es:");
        System.out.println(clase2.generarSerie((ArrayList) serieClase2)+"\n");
        System.out.println("------------ VACIADO DE LISTAS ------------");
        System.out.println("Lista de serie de clase1 se vació: "+clase1.reiniciarSerie()+"\n");
        System.out.println("Lista de serie de clase2 se vació: "+clase2.reiniciarSerie()+"\n");
        System.out.println("--------- FINALIZADO DE PROGRAMA ----------");
    }
}