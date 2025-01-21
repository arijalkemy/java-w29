package Service;

import Model.Deporte;

import java.util.ArrayList;
import java.util.List;

public class DeporteService {
    private List<Deporte> sportList = new ArrayList<>();

    public DeporteService () {
        sportList.add(new Deporte("Football", "High"));
        sportList.add(new Deporte("Basketball", "Medium"));
        sportList.add(new Deporte("Tennis", "Low"));
    }

    public List<Deporte> getAllSports() {
        return sportList;
    }

    public Deporte getSportByName(String name) {
        for (Deporte sport : sportList) {
            if (sport.getNombre().equalsIgnoreCase(name)) {
                return sport;
            }
        }
        return null;
    }
}
