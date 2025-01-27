package com.exceptions.mr_beast.service;

import com.exceptions.mr_beast.dto.BlogEntryDto;
import com.exceptions.mr_beast.exception.BlogAlreadyExistsException;
import com.exceptions.mr_beast.exception.BlogDoesNotExistException;
import com.exceptions.mr_beast.model.BlogEntry;
import com.exceptions.mr_beast.repository.MrBeastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MrBeastService {
    @Autowired
    private MrBeastRepository mrBeastRepository;

    public BlogEntry addBlogEntry(BlogEntryDto blogRequest) {
        BlogEntry blogEntry = toBlogEntry(blogRequest);

        if(mrBeastRepository.getBlogsMap().containsKey(blogRequest.id())) {
            throw new BlogAlreadyExistsException("Blog with the following id already exists: " + blogRequest.id());
        }

        mrBeastRepository.addABlog(blogEntry);
        return blogEntry;
    }

    private BlogEntry toBlogEntry(BlogEntryDto blogRequest) {
        return new BlogEntry(
                blogRequest.id(),
                blogRequest.title(),
                blogRequest.author(),
                LocalDate.now());
    }

    public BlogEntryDto getBlogEntryById(Integer id) {
        BlogEntry blogEntry = mrBeastRepository.getBlogEntryById(id);
        if(blogEntry == null) {
            throw new BlogDoesNotExistException("Blog with the following id does not exist: " + id);
        }

        return toBlogEntryDto(blogEntry);
    }

    private BlogEntryDto toBlogEntryDto(BlogEntry blogEntry) {
        return new BlogEntryDto(blogEntry.getId(), blogEntry.getTitle(), blogEntry.getAuthor());
    }

    public List<BlogEntryDto> getBlogEntries() {
        return mrBeastRepository.getBlogEntries().stream()
                .map(this::toBlogEntryDto)
                .toList();
    }
}
