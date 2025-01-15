package com.thiagoschreck.local.ej_blog.service;

import com.thiagoschreck.local.ej_blog.dto.request.AddBlogRequestDTO;
import com.thiagoschreck.local.ej_blog.dto.response.BlogResponseDTO;
import com.thiagoschreck.local.ej_blog.entity.Blog;
import com.thiagoschreck.local.ej_blog.exception.BlogIdAlreadyExistsException;
import com.thiagoschreck.local.ej_blog.exception.BlogNotFoundException;
import com.thiagoschreck.local.ej_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    private final IBlogRepository repository;

    @Autowired
    public BlogServiceImpl(IBlogRepository repository) {
        this.repository = repository;
    }

    @Override
    public BlogResponseDTO addBlogEntry(AddBlogRequestDTO request) {
        if (repository.findById(request.id()) != null) {
            throw new BlogIdAlreadyExistsException(request.id());
        }
        return map(repository.save(map(request)));
    }

    @Override
    public BlogResponseDTO getBlogEntryById(Integer id) {
        Blog blog = repository.findById(id);
        if (blog == null) {
            throw new BlogNotFoundException(id);
        }
        return map(blog);
    }

    @Override
    public List<BlogResponseDTO> getAllBlogEntries() {
        return map(repository.find());
    }

    private List<BlogResponseDTO> map(List<Blog> blogs) {
        return blogs.stream().map(this::map).toList();
    }

    private BlogResponseDTO map(Blog blog) {
        return new BlogResponseDTO(blog.id(), blog.titulo(), blog.nombre(), blog.fechaDePublicacion());
    }

    private Blog map(AddBlogRequestDTO blogResponse) {
        return new Blog(blogResponse.id(), blogResponse.titulo(), blogResponse.nombre(), blogResponse.fechaDePublicacion());
    }
}
