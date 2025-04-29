import com.mdaneri.Camisa;
import com.mdaneri.Guardaropa;
import com.mdaneri.Pantalon;
import com.mdaneri.Prenda;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Pantalon p1 = new Pantalon("Luis Vuitton", "H1");
        Pantalon p2 = new Pantalon("Bensimon", "Corto");
        Camisa c1 = new Camisa("Bensimon", "Estrellas");
        Camisa c2 = new Camisa("Zara", "Blanca");

        List<Prenda> ticket1 = List.of(p1, c1, c2);
        List<Prenda> ticket2 = List.of(p2);

        Guardaropa guardaropa = new Guardaropa();
        Integer ticketId1 = guardaropa.guardarPrendas(ticket1);
        Integer ticketId2 = guardaropa.guardarPrendas(ticket2);

        guardaropa.devolverPrendas(ticketId2);
        guardaropa.mostrarPrendas();

    }

}