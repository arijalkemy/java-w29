package com.meli.ej_blog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.ej_blog.dto.BlogEntryDTO;
import com.meli.ej_blog.exception.NotFoundException;
import com.meli.ej_blog.exception.ResourceAlreadyExistsException;
import com.meli.ej_blog.model.BlogEntry;
import com.meli.ej_blog.repository.BlogRepositoryImpl;
import com.meli.ej_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {


    private final IBlogRepository blogRepository;

    @Autowired
    public BlogServiceImpl(BlogRepositoryImpl blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public Integer createBlogEntry(BlogEntryDTO blogEntryDTO) {
        Optional<BlogEntry> blogEntry = this.blogRepository.findById(blogEntryDTO.getId());
        if (blogEntry.isPresent()) {
            String errorMsg = String.format("Entrada de blog con id %d ya existe", blogEntryDTO.getId());
            throw new ResourceAlreadyExistsException(errorMsg);
        }

        ObjectMapper mapper = new ObjectMapper();
        return this.blogRepository.save(mapper.convertValue(blogEntryDTO, BlogEntry.class));
    }

    @Override
    public BlogEntryDTO searchBlogEntry(Integer id) {
        Optional<BlogEntry> blogEntry = this.blogRepository.findById(id);
        if (blogEntry.isEmpty()) {
            throw new NotFoundException(String.format("Blog no encontrado con id: %d", id));
        }
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.convertValue(blogEntry.get(), BlogEntryDTO.class);
    }

    @Override
    public List<BlogEntryDTO> searchAllBlogEntries() {
        List<BlogEntry> blogEntries = this.blogRepository.findAll();
        ObjectMapper mapper = new ObjectMapper();
        return blogEntries.stream()
                .map(blogEntry -> mapper.convertValue(blogEntry, BlogEntryDTO.class))
                .toList();

    }
}
