package com.meli.ej_blog.service;

import com.meli.ej_blog.dto.BlogEntryDTO;

import java.util.List;

public interface IBlogService {
    Integer createBlogEntry(BlogEntryDTO blogEntryDTO);
    BlogEntryDTO searchBlogEntry(Integer id);
    List<BlogEntryDTO> searchAllBlogEntries();
}
