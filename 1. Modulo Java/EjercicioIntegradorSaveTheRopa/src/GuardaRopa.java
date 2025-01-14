import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> guardarropa;
    private int contador;

    public GuardaRopa(Map<Integer, List<Prenda>> guardarropa, int contador) {
        this.guardarropa = guardarropa;
        this.contador = contador;
    }

    public int guardarPrendas(List<Prenda> prendas) {
        int id = contador++;
        guardarropa.put(id, prendas);
        return id;
    }

    public void mostrarPrendas(){
        guardarropa.forEach((id, prendas) -> {
            System.out.println("Id de guardarropas : " + id);
            prendas.forEach(System.out::println);
        });
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return guardarropa.get(numero);
    }
}
