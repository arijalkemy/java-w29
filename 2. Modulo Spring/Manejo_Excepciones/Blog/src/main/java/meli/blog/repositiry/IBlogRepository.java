package meli.blog.repositiry;

import meli.blog.entity.Blog;

import java.util.List;

public interface IBlogRepository {

    Blog findById(Integer id);
    List<Blog> findAll();
    Blog save(Blog blog);

}
