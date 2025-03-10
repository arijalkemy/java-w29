import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> armario;
    private Integer contador;

    public GuardaRopa() {
        this.armario = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> prendas) {
        armario.put(this.contador, prendas);
        return contador++;
    }

    public void mostrarPrendas() {
        armario.forEach((key, value) -> {
            System.out.println("ID de armario: " + key);
            value.forEach(System.out::println);
        });
    }

    public List<Prenda> devolverPrenda(Integer id) {
        return this.armario.get(id);
    }
}
