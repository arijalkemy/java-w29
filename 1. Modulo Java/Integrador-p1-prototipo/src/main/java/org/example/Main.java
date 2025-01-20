package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Serie2 seriePar = new Serie2();
        seriePar.setValorInicial(2);

        System.out.println("Serie 2");
        for(int i= 0; i < 6;i++){
            System.out.println(seriePar.getValorSiguiente());
        }
        System.out.println("Valor reiniciado");
        seriePar.reiniciar();
        System.out.println(seriePar.getValorActual());


        Serie3 serie3 = new Serie3();
        serie3.setValorInicial(3);

        for(int i= 0; i < 6;i++){
            System.out.println(serie3.getValorSiguiente());
        }
    }
}