import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    private static List<Localizador> localizadores;

    public Repositorio() {
        this.localizadores = new ArrayList<>();
    }

    public static List<Localizador> getLocalizadoresPorCliente(Cliente cliente) {
        return localizadores.stream().filter(localizador -> localizador.getCliente().equals(cliente)).toList();
    }

}
