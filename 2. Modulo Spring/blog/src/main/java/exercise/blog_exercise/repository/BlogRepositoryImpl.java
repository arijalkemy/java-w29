package exercise.blog_exercise.repository;

import exercise.blog_exercise.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{

    List<EntradaBlog> entradaBlogs;

    public BlogRepositoryImpl() {
        entradaBlogs = new ArrayList<>();
    }

    @Override
    public List<EntradaBlog> getAllBlogs() {
        return entradaBlogs;
    }

    @Override
    public Optional<EntradaBlog> getBlogById(Long id) {
        return entradaBlogs.stream().filter(blog -> blog.getId() == id).findFirst();
    }

    @Override
    public Long saveBlog(EntradaBlog blog) {
        entradaBlogs.add(blog);
        return blog.getId();
    }
}
