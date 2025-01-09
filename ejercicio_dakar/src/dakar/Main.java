package dakar;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Carrera carrera = new Carrera(1000.0, 500.0, "Dakar", 5);

        carrera.darDeAltaAuto(100.0, 200.0, 1.5, "A");
        carrera.darDeAltaAuto(200.0, 300.0, 1.5, "B");
        carrera.darDeAltaAuto(300.0, 400.0, 1.5, "C");

        carrera.darDeAltaMoto(400.0, 500.0, 1.5, "D");
        carrera.darDeAltaMoto(500.0, 600.0, 1.5, "E");
        carrera.darDeAltaMoto(600.0, 700.0, 1.5, "F");

        System.out.println(carrera.getGanadador().getPatente());

    }
}
