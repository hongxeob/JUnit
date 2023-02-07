package site.project.junit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.project.junit.domain.Book;
import site.project.junit.domain.BookRepository;
import site.project.junit.web.dto.BookResponseDto;
import site.project.junit.web.dto.BookSaveRequestDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    //등록
    @Transactional(rollbackFor = RuntimeException.class)
    public BookResponseDto createBook(BookSaveRequestDto requestDto) {
        Book savedBook = bookRepository.save(requestDto.toEntity());
        return new BookResponseDto().toDto(savedBook);


    }

    //목록
    public List<BookResponseDto> bookList() {
        return bookRepository.findAll()
                .stream()
                .map(new BookResponseDto()::toDto)
                .collect(Collectors.toList());
    }

    //한건
    public BookResponseDto findOne(Long id) {
        Optional<Book> findBook = bookRepository.findById(id);
        if (findBook.isPresent()) {
            return new BookResponseDto().toDto(findBook.get());
        } else {
            throw new RuntimeException("해당 ID는 존재하지 않습니다");
        }
    }

    //삭제
    @Transactional(rollbackFor = RuntimeException.class)
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    //수정
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateBook(Long id, BookSaveRequestDto bookSaveRequestDto) {
        Optional<Book> findBook = bookRepository.findById(id);
        if (findBook.isPresent()) {
            Book book = findBook.get();
            book.updateBook(bookSaveRequestDto.getTitle(), bookSaveRequestDto.getAuthor());
        } else {
            throw new RuntimeException("해당 ID의 책을 찾을 수 없습니다");
        }
    }
}