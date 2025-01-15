package _2.ejercicio_youtuber.repository;

import _2.ejercicio_youtuber.model.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    public void saveBlog(EntradaBlog entradaBlog);
    public Optional<EntradaBlog> getBlogById(Long id);
    public List<EntradaBlog> getAllBlogs();
}
