package com.practicablogexepcion.blogexepcion.service;

import com.practicablogexepcion.blogexepcion.dto.request.AddBlogRequestDTO;
import com.practicablogexepcion.blogexepcion.dto.response.BlogResponseDTO;
import com.practicablogexepcion.blogexepcion.entity.Blog;

import java.util.List;

public interface IBlogService {
    BlogResponseDTO addBlogEntry(AddBlogRequestDTO request);

    BlogResponseDTO getBlogEntryById(Integer id);

    List<BlogResponseDTO> getAllBlogEntries();
}
