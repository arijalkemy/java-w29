import java.util.List;

public class Main {
    public static void main(String[] args) {
        Wardrobe wardrobe = new Wardrobe();

        Garment hat = new Garment("Gucci", "M");
        Garment coat = new Garment("The North Face", "L");

        Integer storeId = wardrobe.storeClothes(List.of(hat, coat));
        wardrobe.showClothes();
        List<Garment> retrievedClothes = wardrobe.retrieveClothes(storeId);
        System.out.println("Retrieved clothes: " + retrievedClothes);
    }
}