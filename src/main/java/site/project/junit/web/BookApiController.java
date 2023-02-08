package site.project.junit.web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import site.project.junit.service.BookService;
import site.project.junit.web.dto.request.BookSaveRequestDto;
import site.project.junit.web.dto.response.BookListResponseDto;
import site.project.junit.web.dto.response.BookResponseDto;
import site.project.junit.web.dto.response.CMResponseDto;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BookApiController {
    private final BookService bookService;

    //등록
    @PostMapping("/api/v1/create")
    public ResponseEntity<?> createBook(@RequestBody @Valid BookSaveRequestDto requestDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            throw new RuntimeException(errorMap.toString());
        }
        BookResponseDto responseDto = bookService.createBook(requestDto);
        return new ResponseEntity<>(CMResponseDto.builder().code(1).msg("글 저장 성공").body(responseDto).build(), HttpStatus.CREATED);
    }

    //전체목록
    @GetMapping("/api/v1/books")
    public ResponseEntity<?> getBookList() {
        BookListResponseDto bookListResponseDto = bookService.bookList();
        return new ResponseEntity<>(CMResponseDto.builder().code(1).msg("전체 조회 성공").body(bookListResponseDto).build(), HttpStatus.CREATED);
    }

    //한건찾기
    public ResponseEntity<?> findBookOne() {
        return null;
    }

    //수정
    public ResponseEntity<?> updateBook() {
        return null;
    }

    //삭제
    public ResponseEntity<?> deleteBook() {
        return null;
    }
}
