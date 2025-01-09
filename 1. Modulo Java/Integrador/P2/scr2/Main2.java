public class Main2 {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(500, 10000, "Gran Premio", 10);

        // Dar de alta autos y motos
        carrera.darDeAltaAuto(150, 10, 30, "ABC123");
        carrera.darDeAltaAuto(160, 12, 25, "DEF456");
        carrera.darDeAltaMoto(140, 15, 20, "GHI789");
        carrera.darDeAltaMoto(130, 14, 22, "JKL012");

        // Mostrar vehículos en la carrera
        carrera.mostrarVehiculos();

        // Determinar y mostrar el ganador
        Vehiculo ganador = carrera.determinarGanador();
        System.out.println("El ganador es: " + ganador.getPatente());

        // Socorrer un auto y una moto
        carrera.socorrerAuto("ABC123");
        carrera.socorrerMoto("JKL012");

        // Eliminar un vehículo
        carrera.eliminarVehiculoConPatente("DEF456");

        // Mostrar vehículos en la carrera
        carrera.mostrarVehiculos();


    }
}