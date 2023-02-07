package site.project.junit.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DataJpaTest //DB 관련 컴포넌트만 메모리에 로딩
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    public void setData() {
        String title = "책제목";
        String author = "작가";
        Book book = Book.builder().title(title).author(author).build();
        //when
        bookRepository.save(book);
    }

    // 1. createBook
    @Test
    void 등록() throws Exception {
        //given
        String title = "책제목";
        String author = "작가";
        Book book = Book.builder().title(title).author(author).build();
        //when
        Book savedBook = bookRepository.save(book);
        //then
        assertEquals(title, savedBook.getTitle());
        assertEquals(author, savedBook.getAuthor());
    }

    // 2. BookList
    @Test
    void 목록() throws Exception {
        //given
        String title = "책제목";
        String author = "작가";
        //when
        List<Book> books = bookRepository.findAll();
        //then
        assertEquals(title, books.get(0).getTitle());
        assertEquals(author, books.get(0).getAuthor());
    }

    // 3. findBook
    @Sql("classpath:db/tableInit.sql")
    @Test
    void 한건조회() throws Exception {
        //given
        String title = "책제목";
        String author = "작가";
        //when
        Book findBook = bookRepository.findById(1L).get();
        //then
        assertEquals(title, findBook.getTitle());
        assertEquals(author, findBook.getAuthor());
    }

    // 4. updateBook
    @Sql("classpath:db/tableInit.sql")
    @Test
    void 삭제() throws Exception {
        //given
        Long id = 1L;
        //when
        bookRepository.deleteById(id);
        //then
        assertFalse(bookRepository.findById(id).isPresent());

    }

// 5. deleteBook
}

