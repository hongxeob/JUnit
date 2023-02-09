package site.project.junit.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import site.project.junit.service.BookService;
import site.project.junit.web.dto.request.BookSaveRequestDto;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookApiControllerTest {
    @Autowired
    private BookService bookService;
    @Autowired
    private TestRestTemplate rt;
    private static ObjectMapper om;
    private static HttpHeaders headers;

    @BeforeAll
    public static void init() {
        om = new ObjectMapper();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @Test
    void createBook() throws Exception {
        //given
        BookSaveRequestDto bookSaveRequestDto = new BookSaveRequestDto();
        bookSaveRequestDto.setTitle("제목");
        bookSaveRequestDto.setAuthor("내용");
        String body = om.writeValueAsString(bookSaveRequestDto);
        //when
        HttpEntity<String> request = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = rt.exchange("/api/v1/create", HttpMethod.POST, request, String.class);
        //then
        DocumentContext dc = JsonPath.parse(response.getBody());
        Object title = dc.read("$.body.title");
        Object author = dc.read("$.body.author");
        assertThat(title).isEqualTo("제목");
        assertThat(author).isEqualTo("내용");
    }

}
