package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SerieProgresivaEnteros serieProgresivaEnteros = new SerieProgresivaEnteros(2, 2);
        System.out.println(serieProgresivaEnteros.valorSiguiente());
        System.out.println(serieProgresivaEnteros.valorSiguiente());
        serieProgresivaEnteros.reiniciarSerie();
        System.out.println(serieProgresivaEnteros.valorSiguiente());
        serieProgresivaEnteros.establecerValorInicial(3);
        System.out.println(serieProgresivaEnteros.valorSiguiente());
        System.out.println(serieProgresivaEnteros.valorSiguiente()  );
    }
}