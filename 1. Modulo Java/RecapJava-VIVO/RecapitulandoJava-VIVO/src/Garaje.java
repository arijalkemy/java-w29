import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private Integer id = 0;
    List<Vehiculo> listaVehiculos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public Garaje() {
        this.id += 1;
        this.listaVehiculos = new ArrayList<>();
    }


}
