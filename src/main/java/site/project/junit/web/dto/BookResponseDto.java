package site.project.junit.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import site.project.junit.domain.Book;

@Getter
@NoArgsConstructor
public class BookResponseDto {

    private Long id;
    private String title;
    private String author;

    public BookResponseDto toDto(Book bookEntity) {
        this.id = bookEntity.getId();
        this.title= bookEntity.getTitle();
        this.author= bookEntity.getAuthor();
        return this;
    }
}