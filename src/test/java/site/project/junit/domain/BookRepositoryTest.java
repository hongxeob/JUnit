package site.project.junit.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest //DB 관련 컴포넌트만 메모리에 로딩
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    // 1. createBook
    @Test
    void 책등록() throws Exception {
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

}
// 2. BookList

// 3. findBook

// 4. updateBook

// 5. deleteBook


