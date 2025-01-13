package EjerciciosRepaso;

public class Main {
    public static void main(String[] args){
        
        Garaje garaje = new Garaje(1);

        Vehiculo auto1 = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo auto2 = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo auto3 = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo auto4 = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo auto5 = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo auto6 = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo auto7 = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo auto8 = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo auto9 = new Vehiculo("Toyota", "Corola", 1200);
        Vehiculo auto10 = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo auto11 = new Vehiculo("Renault", "Logan", 950);

        garaje.addVehicle(auto1);
        garaje.addVehicle(auto2);
        garaje.addVehicle(auto3);
        garaje.addVehicle(auto4);
        garaje.addVehicle(auto5);
        garaje.addVehicle(auto6);
        garaje.addVehicle(auto7);
        garaje.addVehicle(auto8);
        garaje.addVehicle(auto9);
        garaje.addVehicle(auto10);
        garaje.addVehicle(auto11);

        System.out.println("Ordenados por Precio:");
        garaje.ordenarVehiculosPorPrecio();
        System.out.println(garaje);
        garaje.ordenarVehiculosPorMarcaYPrecio();
        System.out.println("Ordenados por Marca y Precio:");
        System.out.println(garaje);
        System.out.println("Costo Promedio: " + garaje.calcularCostoPromedio());
        System.out.println("Vehiculos menores a 1000:");
        garaje.obtenerVehiculosPorRangoDePrecio(0,1000);
        System.out.println("Vehiculos mayores a 1000:");

        garaje.obtenerVehiculosPorRangoDePrecio(1000, 999999);
    }
}
