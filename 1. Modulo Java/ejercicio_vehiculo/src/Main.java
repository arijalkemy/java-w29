import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

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

        Garaje garaje = new Garaje(1);
        garaje.setVehiculos(vehiculos);

        /*Haciendo uso del metodo sort en la lista de Vehículos con expresiones lambda,
         obtén una lista de vehículos ordenados por precio de menor a mayor,
         imprime por pantalla el resultado*/

        List<Vehiculo> listaOrdenada = new ArrayList<>(vehiculos);
        listaOrdenada.sort((v1, v2) -> v1.getCosto().compareTo(v2.getCosto()));

        listaOrdenada
                .forEach(vehiculo -> System.out.println("- Marca: " + vehiculo.getMarca() +
                        ", Modelo: " + vehiculo.getModelo() +
                        ", Precio: $ " + vehiculo.getCosto()));

        /*De la misma forma que el ejercicio anterior,
         imprime una lista ordenada por marca y a su vez por precio.*/

        listaOrdenada.sort(Comparator.comparing(Vehiculo::getMarca)
                .thenComparing(Vehiculo::getCosto));

        System.out.println("Lista de vehículos ordenados por marca y precio:");
        listaOrdenada.forEach(vehiculo -> System.out.println("- Marca: " + vehiculo.getMarca() +
                ", Modelo: " + vehiculo.getModelo() +
                ", Precio: $ " + vehiculo.getCosto()));

        /*Se desea extraer una lista de vehículos con precio no mayor a 1000,
         luego otra con precios mayor o igual 1000
         y por último, obtén el promedio total de precios de toda la lista de vehículos.*/

        List<Vehiculo> vehiculosMenorA1000 = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .collect(Collectors.toList());

        List<Vehiculo> vehiculosMayorA1000 = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList());

        Double promedioPrecio = vehiculos.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);

        System.out.println("El promedio del precio de todos los vehículos: $ " + promedioPrecio);



    }
}