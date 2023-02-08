package site.project.junit.web.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class BookListResponseDto {
    List<BookResponseDto> items;

    @Builder
    public BookListResponseDto(List<BookResponseDto> bookResponseDtoList) {
        this.items = bookResponseDtoList;
    }
}
