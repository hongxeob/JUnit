package site.project.junit.web.dto;

import lombok.Getter;
import lombok.Setter;
import site.project.junit.domain.Book;

@Setter
@Getter
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
