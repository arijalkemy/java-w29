package meli.blog.repositiry;

import meli.blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{

    List<Blog> repository =  new ArrayList<>();

    public BlogRepositoryImpl(List<Blog> repository) {
        this.repository = repository;
    }


    @Override
    public Blog findById(Integer id) {
        return repository.stream().filter(blog -> blog.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Blog> findAll() {
        return repository;
    }

    @Override
    public Blog save(Blog blog) {
        repository.add(blog);
        return blog;
    }
}
