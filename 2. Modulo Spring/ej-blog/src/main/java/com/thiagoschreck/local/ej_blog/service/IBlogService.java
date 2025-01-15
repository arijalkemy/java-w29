package com.thiagoschreck.local.ej_blog.service;

import com.thiagoschreck.local.ej_blog.dto.request.AddBlogRequestDTO;
import com.thiagoschreck.local.ej_blog.dto.response.BlogResponseDTO;

import java.util.List;

public interface IBlogService {
    BlogResponseDTO addBlogEntry(AddBlogRequestDTO request);

    BlogResponseDTO getBlogEntryById(Integer id);

    List<BlogResponseDTO> getAllBlogEntries();
}
