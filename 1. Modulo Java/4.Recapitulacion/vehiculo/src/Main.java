import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();

        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));


        Garaje garaje = new Garaje(1, vehiculos);


        System.out.println("\n VEHÍCULOS ORDENADOS POR PRECIO \n");
        List<Vehiculo> vehiculosOrdenadosPorPrecio = garaje.getVehiculosOrdenadosPorPrecio();
        garaje.mostrarVehiculos(vehiculosOrdenadosPorPrecio);

        System.out.println("\n VEHÍCULOS ORDENADOS POR PRECIO Y MARCA \n");
        List<Vehiculo> vehiculosOrdenadosPorMarcaYPrecio = garaje.getVehiculosOrdenadosPorMarcaYPrecio();
        garaje.mostrarVehiculos(vehiculosOrdenadosPorMarcaYPrecio);

        System.out.println("\n VEHÍCULOS CON PRECIO NO MAYOR A 1000 \n");
        List<Vehiculo> vehiculosPrecioNoMayorAMil = garaje.getVehiculosPrecioNoMayorAMil();
        garaje.mostrarVehiculos(vehiculosPrecioNoMayorAMil);

        System.out.println("\n VEHÍCULOS CON PRECIO MAYOR O IGUAL A 1000 \n");
        List<Vehiculo> vehiculosPrecioMayorIgualAMil = garaje.getVehiculosPrecioMayorIgualAMil();
        garaje.mostrarVehiculos(vehiculosPrecioMayorIgualAMil);

        Double promedioPrecio = garaje.getPromedioPrecio();
        System.out.println("\n Promedio total precios = " + promedioPrecio);
    }
}