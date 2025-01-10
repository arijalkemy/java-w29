import model.Cliente;
import model.Localizador;
import model.RepositorioCliente;
import model.Reserva;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public class MainPrincipal {
    public static void main(String[] args) {
        // Crear repositorio de clientes
        RepositorioCliente repositorio = new RepositorioCliente();

        // Crear cliente
        Cliente cliente = new Cliente("Juan");

        // 1. Crear un localizador con un paquete completo
        Localizador localizador1 = new Localizador(cliente,
                Arrays.asList(
                        new Reserva("hotel", 100),
                        new Reserva("comida", 50),
                        new Reserva("boleto", 150),
                        new Reserva("transporte", 30)
                ));

        // Guardar cliente en repositorio
        repositorio.agregarCliente(cliente);
        // Imprimir resultado
        localizador1.imprimir();

        // 2. Crear un localizador con 2 reservas de hotel y 2 de boletos
        Localizador localizador2 = new Localizador(cliente,
                Arrays.asList(
                        new Reserva("hotel", 100),
                        new Reserva("hotel", 120),
                        new Reserva("boleto", 150),
                        new Reserva("boleto", 140)
                ));

        // Imprimir resultado
        localizador2.imprimir();

        // 3. Crear un localizador con una sola reserva
        Localizador localizador3 = new Localizador(cliente,
                Arrays.asList(
                        new Reserva("comida", 40)
                ));

        // Imprimir resultado
        localizador3.imprimir();
    }
}
