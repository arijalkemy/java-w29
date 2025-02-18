package com.mercadolibre.bootcamp.obrasliterarias.dto;

import com.mercadolibre.bootcamp.obrasliterarias.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class BookDTO {

    private String title;
    private String author;
    private Integer pagesCount;
    private String editorial;
    private LocalDate publishedAt;

    public static Book to(BookDTO dto) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(dto.getAuthor());
        book.setPagesCount(dto.getPagesCount());
        book.setEditorial(dto.getEditorial());
        book.setPublishedAt(dto.getPublishedAt());
        return book;
    }

    public static BookDTO from(Book book) {
        return new BookDTO(
                book.getTitle(),
                book.getAuthor(),
                book.getPagesCount(),
                book.getEditorial(),
                book.getPublishedAt()
        );
    }

}

