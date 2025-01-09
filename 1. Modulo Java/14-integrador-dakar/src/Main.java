import model.Carrera;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(100.0, 100000.0, "Elo's Racing", 5);
        carrera.darDeAltaAuto(150.0, 12.0, 110.0, "123");
        carrera.darDeAltaAuto(600.0, 62.0, 150.0, "456");
        carrera.darDeAltaAuto(300.0, 22.0, 10.0, "789");
        carrera.darDeAltaMoto(23.2, 14.0, 33.0, "342");
        carrera.darDeAltaMoto(66.9, 87.9, 3.9, "453");
        carrera.darDeAltaMoto(76.7, 4.5, 22.3, "126");
        System.out.println("Vehiculos registrados: " + carrera.getVehiculos().size());

        // eliminar vehiculo
        carrera.eliminarVehiculoConPatente("456");
        System.out.println("\nVehiculos registrados luego de eliminar uno: " + carrera.getVehiculos().size());

        // definir ganador
        System.out.println(carrera.definirGanador());

        // socorrer
        carrera.socorrerAuto("123");
        carrera.socorrerMoto("342");
    }
}