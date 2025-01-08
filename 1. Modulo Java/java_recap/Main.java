package java_recap;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    Garaje garaje = new Garaje(1, List.of(
      new Vehiculo("Fiesta", "Ford", 1000.0),
      new Vehiculo("Focus", "Ford", 1200.0),
      new Vehiculo("Explorer", "Ford", 2500.0),
      new Vehiculo("Uno", "Fiat", 500.0),
      new Vehiculo("Cronos", "Fiat", 1000.0),
      new Vehiculo("Torino", "Fiat", 1250.0),
      new Vehiculo("Aveo", "Chevrolet", 1250.0),
      new Vehiculo("Spin", "Chevrolet", 2500.0),
      new Vehiculo("Corolla", "Toyota", 1200.0),
      new Vehiculo("Fortuner", "Toyota", 3000.0),
      new Vehiculo("Logan", "Renault", 950.0)
    ));
    List<Vehiculo> vehiculos = garaje.sortPrice();
    vehiculos.forEach(System.out::println);
    System.out.println("=====================================");
    vehiculos = garaje.sortBrandPrice();
    vehiculos.forEach(System.out::println);
    System.out.println("=====================================");
    vehiculos = garaje.selectPrice(precio -> precio < 1000.0);
    vehiculos.forEach(System.out::println);
    System.out.println("=====================================");
    vehiculos = garaje.selectPrice(precio -> precio >= 1000.0);
    vehiculos.forEach(System.out::println);
    System.out.println("=====================================");
    System.out.println("Promedio de precios: " + garaje.getAveragePrice());
  }
}