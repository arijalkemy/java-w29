package models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer id;
    private Map<Integer,List<Prenda>> prendas;



   public GuardaRopa() {
       this.prendas = new HashMap<>();
       this.id = 0;
   }


    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public Integer nextId(){
       this.id = this.id+1;
       return this.id;
    }



    public Integer guardarPrendas(List<Prenda> prendasGuardar) {
       this.prendas.put(nextId(), prendasGuardar);
       return this.id;
    }

    public List<Prenda> getPrendasGuardada(Integer id) {
       return this.prendas.get(id);
    }
}
