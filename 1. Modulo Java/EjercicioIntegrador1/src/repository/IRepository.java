package repository;

import java.util.List;

public interface IRepository<T>{
    void save(T client);
    List<T> getAll();
}
