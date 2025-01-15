package exercise.blog_exercise.service;

import exercise.blog_exercise.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    public List<EntradaBlog> getAllBlogs();

    public Optional<EntradaBlog> getBlogById(Long id);

    public Long saveBlog(EntradaBlog blog);
}
