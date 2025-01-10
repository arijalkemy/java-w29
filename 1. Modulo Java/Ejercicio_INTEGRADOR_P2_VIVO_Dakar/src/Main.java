import com.mdaneri.Auto;
import com.mdaneri.Carrera;
import com.mdaneri.Moto;
import com.mdaneri.Vehiculo;

public class Main {

    public static void main(String[] args) {

        Carrera c = new Carrera(280 ,10000, "UnaCarrera", 10);
        c.darDeAltaMoto(150, 8, 30d, "ASD123");
        c.darDeAltaAuto(280, 15, 25d, "ASD456");
        c.darDeAltaAuto(210, 20, 15d, "ASD789");
        System.out.println(c.ganador());

        c.socorrerAuto("ASD456");

    }

}