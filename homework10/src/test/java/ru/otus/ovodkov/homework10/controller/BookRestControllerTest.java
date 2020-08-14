package ru.otus.ovodkov.homework10.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.ovodkov.homework10.api.BookRestController;
import ru.otus.ovodkov.homework10.entity.Author;
import ru.otus.ovodkov.homework10.entity.Book;
import ru.otus.ovodkov.homework10.entity.Comment;
import ru.otus.ovodkov.homework10.entity.Genre;
import ru.otus.ovodkov.homework10.service.BookService;

import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author Ovodkov Sergey
 * created on 12.08.2020
 */
@WebMvcTest(BookRestController.class)
public class BookRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookService bookService;

    private static final long ID_BOOK = 1L;
    private static final String TITLE_BOOK = "C# 6.0. Справочник";
    private static final int EDITION = 6;
    private static final int YEAR_PUBLISHING = 2017;
    private static final Set<Comment> COMMENTS = Set.of(new Comment());
    private static final Set<Author> AUTHORS = Set.of(new Author());
    private static final Set<Genre> GENRES = Set.of(new Genre());

    @Test
    @DisplayName("Получение количества книг")
    public void givenCountBook_whenGetCountBooks_returnCountBooks() throws Exception {
        Book book = new Book(ID_BOOK, TITLE_BOOK, EDITION, YEAR_PUBLISHING, COMMENTS, AUTHORS, GENRES);

        List<Book> books = List.of(book);

        given(bookService.getBooks()).willReturn(books);

        mvc.perform(get("/api/books"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(books.size())));
    }
}
