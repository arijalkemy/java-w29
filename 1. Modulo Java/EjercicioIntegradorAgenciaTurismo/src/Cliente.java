import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private final String nombre;
    private final List<Localizador> localizadores;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.localizadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }
}
