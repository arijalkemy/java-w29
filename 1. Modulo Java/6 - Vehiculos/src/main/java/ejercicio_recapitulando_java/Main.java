package ejercicio_recapitulando_java;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Vehiculo("Fiesta", "Ford", 1000);
        Vehiculo vehiculo2 = new Vehiculo("Focus", "Ford", 1200);
        Vehiculo vehiculo3 = new Vehiculo("Explorer", "Ford", 2500);
        Vehiculo vehiculo4 = new Vehiculo("Uno", "Fiat", 500);
        Vehiculo vehiculo5 = new Vehiculo("Cronos", "Fiat", 1000);
        Vehiculo vehiculo6 = new Vehiculo("Torino", "Fiat", 1250);
        Vehiculo vehiculo7 = new Vehiculo("Aveo", "Chevrolet", 1250);
        Vehiculo vehiculo8 = new Vehiculo("Spin", "Chevrolet", 2500);
        Vehiculo vehiculo9 = new Vehiculo("Corola", "Toyota", 1200);
        Vehiculo vehiculo10 = new Vehiculo("Fortuner", "Toyota", 3000);
        Vehiculo vehiculo11 = new Vehiculo("Logan", "Renault", 950);

        ArrayList<Vehiculo> vehiculosList = new ArrayList<>();
        vehiculosList.add(vehiculo1);
        vehiculosList.add(vehiculo2);
        vehiculosList.add(vehiculo3);
        vehiculosList.add(vehiculo4);
        vehiculosList.add(vehiculo5);
        vehiculosList.add(vehiculo6);
        vehiculosList.add(vehiculo7);
        vehiculosList.add(vehiculo8);
        vehiculosList.add(vehiculo9);
        vehiculosList.add(vehiculo10);
        vehiculosList.add(vehiculo11);

        Garaje test = new Garaje(1, vehiculosList);

        System.out.println("Marca   Modelo    Costo");
        test.getVehiculos().sort((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()));
        System.out.println(test.getVehiculos());

        //Otra Forma
        System.out.println("Marca   Modelo    Costo");
        test.getVehiculos().sort(Comparator.comparing(Vehiculo::getMarca).thenComparingDouble(Vehiculo::getCosto));
        /*test.getVehiculos().sort((v1, v2) -> {

            int orden = v1.getMarca().compareTo(v2.getMarca());

            if (orden == 0) {
                orden = Double.compare(v1.getCosto(), v2.getCosto());
            }
            return orden;
        });*/
        System.out.println(test.getVehiculos());


        System.out.println("\nVehiculos con costo mayor a 1000");
        System.out.println("\nMarca   Modelo    Costo");
        test.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() > 1000).forEach(System.out::print);

        System.out.println("\nVehiculos con costo menor o igual a 1000");
        System.out.println("\nMarca   Modelo    Costo");
        test.getVehiculos().stream().filter(vehiculo -> vehiculo.getCosto() <= 1000).forEach(System.out::print);

        System.out.println("\nPromedio de costo de los vehiculos");
        double promedio = test.getVehiculos().stream().mapToDouble(Vehiculo::getCosto).average().orElse(0);
        System.out.println("%.2f".formatted(promedio));
    }
}