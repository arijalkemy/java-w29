package exercise.blog_exercise.repository;

import exercise.blog_exercise.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    public List<EntradaBlog> getAllBlogs();

    public Optional<EntradaBlog> getBlogById(Long id);

    public Long saveBlog(EntradaBlog blog);
}
