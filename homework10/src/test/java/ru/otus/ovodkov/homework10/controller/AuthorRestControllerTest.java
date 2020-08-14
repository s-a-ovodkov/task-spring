package ru.otus.ovodkov.homework10.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.ovodkov.homework10.api.AuthorRestController;
import ru.otus.ovodkov.homework10.entity.Author;
import ru.otus.ovodkov.homework10.entity.Book;
import ru.otus.ovodkov.homework10.service.AuthorService;

import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Ovodkov Sergey
 * created on 12.08.2020
 */
@WebMvcTest(AuthorRestController.class)
public class AuthorRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AuthorService authorService;

    private static final long ID_AUTHOR = 1L;
    private static final String FIRST_NAME = "Джозеф";
    private static final String LAST_NAME = "Албахари";
    private static final Set<Book> BOOKS = Set.of(new Book());

    @Test
    @DisplayName("получение списка авторов")
    public void givenAuthors_whenGetAuthors_returnJsonArray() throws Exception {
        Author author = new Author(ID_AUTHOR, FIRST_NAME, LAST_NAME, BOOKS);
        List<Author> authors = List.of(author);

        given(authorService.getAuthors()).willReturn(authors);

        mvc.perform(get("/api/authors/"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}
