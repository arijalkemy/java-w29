import java.util.ArrayList;
import java.util.List;

public class Localizador {

    private Cliente cliente;
    private List<Reserva> reservas;
    private double total;
    private double descuento;

    public Localizador(Cliente cliente, List<Reserva> reservas, double total) {
        this.cliente = cliente;
        this.reservas = reservas;
        this.total = total;
        this.descuento = 0;
    }

    private void almacenarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    private void cargarCliente(Cliente cliente) {
        this.cliente = new Cliente("Lucas","Quintana",25,"232323");
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Localizador: " +
                "cliente: " + cliente.getNombre() +
                ", reservas: " + reservas +
                ", total " + total +
                ", descuento: " + (descuento*100) + "%";
    }
}
