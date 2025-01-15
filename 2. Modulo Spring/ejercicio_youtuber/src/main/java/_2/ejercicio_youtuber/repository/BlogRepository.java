package _2.ejercicio_youtuber.repository;

import _2.ejercicio_youtuber.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository

public class BlogRepository implements IBlogRepository{

    private List<EntradaBlog> entradaBlogsList = new ArrayList<>();


    @Override
    public void saveBlog(EntradaBlog entradaBlog) {
        entradaBlogsList.add(entradaBlog);

    }

    @Override
    public Optional<EntradaBlog> getBlogById(Long id) {
        return entradaBlogsList.stream().filter(eb -> eb.getId().equals(id)).findFirst();
    }

    @Override
    public List<EntradaBlog> getAllBlogs() {
        return entradaBlogsList;
    }
}
