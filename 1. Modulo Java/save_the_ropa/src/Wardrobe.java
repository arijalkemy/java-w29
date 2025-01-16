import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wardrobe {
    private Integer counter;
    private Map<Integer, List<Garment>> storedClothes;

    public Wardrobe() {
        counter = 0;
        storedClothes = new HashMap<>();
    }

    public Integer storeClothes(List<Garment> clothes) {
        storedClothes.put(++counter, clothes);
        return counter;
    }

    public void showClothes() {
        System.out.println("Clothes stored in the wardrobe: " + this.getStoredClothes());
    }

    public List<Garment> retrieveClothes(Integer number) {
        return storedClothes.get(number);
    }

    public Map<Integer, List<Garment>> getStoredClothes() {
        return storedClothes;
    }
}
