package site.project.junit.web.dto;

import lombok.Setter;
import org.springframework.stereotype.Controller;
import site.project.junit.domain.Book;

@Setter
public class BookSaveRequestDto {
    private String title;
    private String author;

    public Book toEntity() {
        return Book.builder()
                .title(title)
                .author(author)
                .build();
    }
}
