package Repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T, K> {

    List<T> findAll();

    Optional<T> findById(K id);

    T save(T t);

    void delete(T t);

    T update(T t);

}
