import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Fiesta", "Ford", 1000));
        vehiculos.add(new Vehiculo("Focus", "Ford", 1200));
        vehiculos.add(new Vehiculo("Explorer", "Ford", 2500));
        vehiculos.add(new Vehiculo("Uno", "Fiat", 500));
        vehiculos.add(new Vehiculo("Cronos", "Fiat", 1000));
        vehiculos.add(new Vehiculo("Torino", "Fiat", 1250));
        vehiculos.add(new Vehiculo("Aveo", "Chevrolet", 1250));
        vehiculos.add(new Vehiculo("Spin", "Chevrolet", 2500));
        vehiculos.add(new Vehiculo("Corola", "Toyota", 1200));
        vehiculos.add(new Vehiculo("Fortuner", "Toyota", 3000));
        vehiculos.add(new Vehiculo("Logan", "Renault", 950));

        Garaje garaje = new Garaje(1, vehiculos);

        System.out.println("-------------------------------------------------");
        System.out.println("Vehiculos ordenados por precio de menor a mayor");

        // lista de vehiculos ordenados por precio de menor a mayor usando lambda y mostrar en consola
        garaje.getVehiculos().stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(v -> System.out.println(v.getModelo() + " " + v.getMarca() + " " + v.getCosto()));

        // lista de vehiculos ordenado por marca y por precio de menor a mayor usando labda y mostrar en consola
        System.out.println("-------------------------------------------------");
        System.out.println("Vehiculos ordenados por marca y por precio de menor a mayor");
        garaje.getVehiculos().stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(v -> System.out.println(v.getModelo() + " " + v.getMarca() + " " + v.getCosto()));

        // lista de vehiculos con precio no mayor a 1000 usando lambda y mostrar en consola
        System.out.println("-------------------------------------------------");
        System.out.println("Vehiculos con precio no mayor a 1000");
        garaje.getVehiculos().stream()
                .filter(v -> v.getCosto() <= 1000)
                .forEach(v -> System.out.println(v.getModelo() + " " + v.getMarca() + " " + v.getCosto()));
    }
}