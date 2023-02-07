package site.project.junit.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest //DB 관련 컴포넌트만 메모리에 로딩
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    // 1. createBook
    @Test
    public void 책등록() throws Exception {
        //given
        System.out.println("BookRepositoryTest.책등록");
        //when

        //then

    }
    // 2. BookList

    // 3. findBook

    // 4. updateBook

    // 5. deleteBook

}
