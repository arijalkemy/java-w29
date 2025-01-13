import java.util.ArrayList;
import java.util.List;

public class Localizador {

    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;

    public Localizador(double total, Cliente cliente) {
        this.total = total;
        this.cliente = cliente;
        this.reservas = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public int obtenerDescuento() {
        List<Localizador> localizadores = Repositorio.getLocalizadoresPorCliente(cliente);
        int descuento = 0;

        if (localizadores.size() >= 2) {
            descuento += 5;
        }

        List<Reserva.Tipo> tiposReserva = reservas.stream().map(Reserva::getTipo).toList();
        List<Reserva.Tipo> tiposDescuentos10 = List.of(Reserva.Tipo.HOTEL, Reserva.Tipo.TRANSPORTE, Reserva.Tipo.BOLETO, Reserva.Tipo.COMIDA);

        if (tiposReserva.containsAll(tiposDescuentos10)) {
            descuento += 10;
        }

        final List<Reserva.Tipo> tiposHotelDescuento5 = List.of(Reserva.Tipo.HOTEL, Reserva.Tipo.HOTEL);
        final List<Reserva.Tipo> tiposBoletoDescuento5 = List.of(Reserva.Tipo.BOLETO, Reserva.Tipo.BOLETO);
        if (tiposReserva.containsAll(tiposHotelDescuento5) || tiposReserva.containsAll(tiposBoletoDescuento5)) {
            descuento += 5;
        }

        return descuento;
    }


}
