package org.example.ej_blog.Exceptions;

public class NoFoundBlog extends RuntimeException {

    public NoFoundBlog(String message) {
        super(message);
    }
}
