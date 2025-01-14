public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(1000.0, 5000.0, "Gran Premio", 5);

        System.out.println("Dando de alta vehículos:");
        carrera.darDeAltaAuto(150.0, 10.0, 20.0, "ABC-123");
        carrera.darDeAltaMoto(100.5, 15.7, 30.2, "DEF-456");
        carrera.darDeAltaAuto(180.3, 8.4, 25.5, "GHI-789");
        carrera.darDeAltaMoto(120.1, 12.3, 15.6, "JKL-101");
        carrera.darDeAltaAuto(160.2, 9.9, 22.2, "MNO-112");
        imprimirVehiculos(carrera);


        System.out.println("\nIntentar agregar un vehículo cuando la carrera ya está completa:");
        carrera.darDeAltaAuto(170.0, 11.0, 18.0, "PQR-131");



        Vehiculo ganador = carrera.getGanador();
        if (ganador != null) {
            System.out.println("\nEl ganador es el vehículo con patente: " + ganador.getPatente());
        }

        System.out.println("\nRealizando operaciones de socorro:");
        carrera.socorrerAuto("ABC-123");
        carrera.socorrerMoto("DEF-456");

        System.out.println("\nEliminando vehículos:");

        Vehiculo vehiculoAEliminar = new Auto(180.3, 8.4, 25.5, "GHI-789");
        carrera.eliminarVehiculo(vehiculoAEliminar);

        carrera.eliminarVehiculoConPatente("JKL-101");

        System.out.println("\nLista de vehículos después de las eliminaciones:");

        imprimirVehiculos(carrera);
    }

    private static void imprimirVehiculos(Carrera carrera) {
        for (Vehiculo vehiculo : carrera.getVehiculosList()) {
            System.out.println("Vehiculo: Patente = " + vehiculo.getPatente() +
                    ", Velocidad = " + vehiculo.getVelocidad() + " km/h, " +
                    "Aceleración = " + vehiculo.getAceleracion() + " m/s², " +
                    "Ángulo de Giro = " + vehiculo.getAnguloDeGiro() + " grados");
        }
        System.out.println("Actualmente hay " + carrera.getVehiculosCount() + " vehículos en la carrera");
    }
}

