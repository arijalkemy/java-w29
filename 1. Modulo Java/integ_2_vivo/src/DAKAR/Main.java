package DAKAR;

import DAKAR.model.Auto;
import DAKAR.model.Moto;

public class Main {

    public static void main(String[] args) {
        Socorrista<Auto> socorristaDeAutos = new Socorrista<>();
        Socorrista<Moto> socorristaDeMotos = new Socorrista<>();

        Carrera carrera = new Carrera(
                5000.0, // distancia
                10000.0, // premioEnDolares
                "Gran Carrera",
                5, // cantidadDeVehiculosPermitidos
                socorristaDeAutos,
                socorristaDeMotos
        );

        carrera.darDeAltaAuto(150.0, 10.5, 50.0, "AUTO123");
        carrera.darDeAltaMoto(120.0, 8.5, 45.0, "MOTO123");

        carrera.definirGanador();

        carrera.socorrerAuto("AUTO123");
        carrera.socorrerMoto("MOTO123");
    }

}
