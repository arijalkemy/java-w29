package Repository;

import java.util.List;
import java.util.Optional;

public interface CRUD <T> {

    void create(T t);

    void delete(Integer id);

    T get(Integer id);

    List<T> getAll();

}
