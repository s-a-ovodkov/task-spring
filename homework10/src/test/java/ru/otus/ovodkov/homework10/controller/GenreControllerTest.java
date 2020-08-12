package ru.otus.ovodkov.homework10.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.otus.ovodkov.homework10.entity.Book;
import ru.otus.ovodkov.homework10.entity.Genre;
import ru.otus.ovodkov.homework10.service.GenreService;

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
@WebMvcTest(GenresController.class)
public class GenreControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private GenreService genreService;

    private static final long ID_GENRE = 1L;
    private static final String NAME_GENRE = "C#";
    private static final String DESCRIPTION_GENRE = "Тоже не плохой язык программирования";
    private static final Set<Book> BOOKS = Set.of(new Book());

    @Test
    @DisplayName("получение списка жанров")
    public void givenGenres_whenGetGenres_returnJsonArray() throws Exception {
        Genre genre = new Genre(ID_GENRE, NAME_GENRE, DESCRIPTION_GENRE, BOOKS);
        List<Genre> genres = List.of(genre);

        given(genreService.getGenres()).willReturn(genres);

        mvc.perform(get("/api/genres/"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }
}
