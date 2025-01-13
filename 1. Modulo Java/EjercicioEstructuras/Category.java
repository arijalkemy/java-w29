import java.util.ArrayList;
import java.util.List;

public class Category {
    public int id;
    public String name;
    public String description;
    public List<Inscription> subscriptions;

    public Category(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        //Lista vacia de inscritos
        this.subscriptions = new ArrayList<Inscription>();
    }
}
