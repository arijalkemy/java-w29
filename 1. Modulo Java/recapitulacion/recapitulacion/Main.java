package recapitulacion;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Vehiculo fordFiesta = new Vehiculo("1000", "Ford", "Fiesta");
        Vehiculo fordFocus = new Vehiculo("1200", "Ford", "Focus");
        Vehiculo fordExplorer = new Vehiculo("2500", "Ford", "Explorer");
        Vehiculo fiatUno = new Vehiculo("500", "Fiat", "Uno");
        Vehiculo fiatCronos = new Vehiculo("1000", "Fiat", "Cronos");
        Vehiculo fiatTorino = new Vehiculo("1250", "Fiat", "Torino");
        Vehiculo chevroletAveo = new Vehiculo("1250", "Chevrolet", "Aveo");
        Vehiculo chevroletSpin = new Vehiculo("2500", "Chevrolet", "Spin");
        Vehiculo toyotaCorola = new Vehiculo("1200", "Toyota", "Corola");
        Vehiculo toyotaFortuner = new Vehiculo("3000", "Toyota", "Fortuner");
        Vehiculo renaultLogan = new Vehiculo("950", "Renault", "Logan");
        Vehiculo[] listaVehiculo = {
                fordFiesta, fordFocus, fordExplorer, fiatUno, fiatCronos,
                fiatTorino, chevroletAveo, chevroletSpin, toyotaCorola, renaultLogan
        };
        Garaje garaje = new Garaje(1, listaVehiculo);
        Vehiculo[] listaVehiculoOrdenada = listaVehiculo;
        Arrays.sort(listaVehiculoOrdenada, Comparator.comparingInt(v -> Integer.parseInt(v.getCosto())));
        Vehiculo[] listaVehiculoOrdenadaNombre = listaVehiculo;
        Arrays.sort(listaVehiculoOrdenadaNombre, Comparator
                .comparingInt((Vehiculo v) -> Integer.parseInt(v.getCosto()))
                .thenComparing(v -> v.getMarca()));
        System.out.println("Vehículos creados exitosamente.");
        System.out.println("lista original");
        Arrays.stream(listaVehiculo).forEach(v -> System.out.println(v.toString()));
        System.out.println("lista Ordenada");
        Arrays.stream(listaVehiculoOrdenada).forEach(v -> System.out.println(v.toString()));
        System.out.println("lista Ordenada por precio y nombre");
        Arrays.stream(listaVehiculoOrdenadaNombre).forEach(v -> System.out.println(v.toString()));

        double promedio = Arrays.stream(listaVehiculo)
                .mapToInt(v -> Integer.parseInt(v.getCosto()))
                .average()
                .orElse(0);

        System.out.println("Promedio: " + promedio);
    }
}