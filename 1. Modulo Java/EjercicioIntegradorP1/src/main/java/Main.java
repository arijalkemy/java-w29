import model.Cliente;
import model.Localizador;
import model.Reserva;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Reserva hotel = new Reserva("Hotel", 2000.0);
        Reserva comida = new Reserva("Comida", 1000.0);
        Reserva transporte = new Reserva("Transporte", 500.0);
        Reserva boleto = new Reserva("Botelo", 5000.0);
        List<Reserva> reservas = new ArrayList<>();
        reservas.add(hotel);
        reservas.add(comida);
        reservas.add(transporte);
        reservas.add(boleto);

        Cliente c1 = new Cliente(1, "Martin", "Rodriguez");

        Localizador localizador = new Localizador(c1, reservas);
        System.out.println(localizador.getTotal());
    }
}
