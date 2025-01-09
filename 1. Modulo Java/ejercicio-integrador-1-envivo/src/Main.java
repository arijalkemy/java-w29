import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Lucas","Quintana",25,"425062302");
        Cliente cliente2 = new Cliente("Pedro","Perez",22,"432323202");
        Cliente cliente3 = new Cliente("Juan","Maidana",20,"45435432");


        List<Reserva> reservas = Arrays.asList(new Reserva(Reserva.TipoReserva.HOTEL), new Reserva(Reserva.TipoReserva.HOTEL));

        Localizador loc1 = new Localizador(cliente1,reservas,150);

        RepositorioCliente repo = new RepositorioCliente();
        repo.agregarCliente(cliente1);
        repo.agregarLocalizador(cliente1, loc1);
        System.out.println(loc1.toString());


    }
}