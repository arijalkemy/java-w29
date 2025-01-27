package com.exceptions.mr_beast.repository;

import com.exceptions.mr_beast.model.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MrBeastRepository {
    private final Map<Integer, BlogEntry> blogs = new HashMap<>();

    public void addABlog(BlogEntry blogEntry) {
        blogs.put(blogEntry.getId(), blogEntry);
    }

    public BlogEntry getBlogEntryById(Integer id) {
        return blogs.get(id);
    }

    public Map<Integer, BlogEntry> getBlogsMap() {
        return blogs;
    }

    public List<BlogEntry> getBlogEntries() {
        return blogs.values().stream().toList();
    }
}
