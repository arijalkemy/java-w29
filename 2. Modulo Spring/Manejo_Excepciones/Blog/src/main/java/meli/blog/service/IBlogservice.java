package meli.blog.service;

import meli.blog.dto.BlogDto;
import meli.blog.entity.Blog;

import java.util.List;

public interface IBlogservice {

    Integer create(BlogDto blogDto);
    Blog findBlog (Integer id);
    List<Blog> getAll();
}
