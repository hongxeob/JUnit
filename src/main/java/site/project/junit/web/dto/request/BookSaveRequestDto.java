package site.project.junit.web.dto.request;

import lombok.Getter;
import lombok.Setter;
import site.project.junit.domain.Book;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
public class BookSaveRequestDto {
    @NotBlank
    @Size(min = 1, max = 50)
    private String title;

    @Size(min = 2, max = 20)
    @NotBlank
    private String author;

    public Book toEntity() {
        return Book.builder()
                .title(title)
                .author(author)
                .build();
    }
}
