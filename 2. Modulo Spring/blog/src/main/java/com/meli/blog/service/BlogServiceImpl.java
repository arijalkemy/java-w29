package com.meli.blog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.blog.dto.request.CreateBlogDto;
import com.meli.blog.dto.response.CreatedBlogDto;
import com.meli.blog.exception.NotFoundException;
import com.meli.blog.entity.Blog;
import com.meli.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService{
    private IBlogRepository blogRepository;
    private ObjectMapper ob;

    @Autowired
    public BlogServiceImpl(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
        this.ob = new ObjectMapper();
    }

    @Override
    public CreatedBlogDto save(CreateBlogDto blog) {
        if(blogRepository.existsById(blog.getId()))
            throw new NotFoundException("Blog already exists");
        Blog convertedBlog = ob.convertValue(blog, Blog.class);
        Blog savedBlog = blogRepository.save(convertedBlog);
        return new CreatedBlogDto(savedBlog.getId());
    }

    @Override
    public Blog getBlogById(Integer id) {
        Blog blog = this.blogRepository.findById(id);
        if (blog == null)
            throw new NotFoundException("Blog not found");
        return blog;
    }

    @Override
    public List<Blog> findAllBlogs() {
        List<Blog> blogs = this.blogRepository.findAll();
        if (blogs.isEmpty())
            throw new NotFoundException("Blogs not found");
        return blogs;
    }
}
