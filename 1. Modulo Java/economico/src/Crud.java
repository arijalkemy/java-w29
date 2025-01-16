import java.util.List;
import java.util.Optional;

public interface Crud<T> {
    public Optional<T> getEntity(String id);

    public List<T> getEntities();

    public void saveEntity(T entity);

    public void deleteEntity(T entity);

    public void printEntity(String id);

    public void printEntities();
}
