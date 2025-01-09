import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> almacen = new HashMap<Integer, List<Prenda>>();
    private Integer contador = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        almacen.put(++contador,listaDePrenda);
        return contador;
    }

    public void mostrarPrendas(){
        for(Integer i : almacen.keySet()){
            for(Prenda prenda : almacen.get(i)){
                System.out.println("ID: " + i + "Marca: "+prenda.getMarca() + "Modelo: " + prenda.getModelo());
            }
        }


    }

    public List<Prenda> devolverPrendas(Integer numero){
        return almacen.get(numero);
    }


}
