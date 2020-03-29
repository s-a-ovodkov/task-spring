package ru.otus.ovodkov.homework5.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.ovodkov.homework5.domain.Genre;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DAO для работы с жанрами книг")
@JdbcTest
@Import(GenreDaoJdbc.class)
public class GenreDaoJdbcTest {

    @Autowired
    private GenreDaoJdbc dao;

    private static final long EXPECTED_ID_GENRE = 1L;
    private static final String EXPECTED_GENRE_NAME = "Java";
    private static final String GENRE_NAME_NEW = "C#";
    private static final String GENRE_DESCRIPTION_NEW = "Тоже не плохой язык программирования";
    private static final long EXPECTED_COUNT_GENRE = 2L;

    @DisplayName("возвращает жанр по указаному идентификатору")
    @Test
    void shouldReturnExpectedGenreByIdGenre() {
        Genre actual = dao.getByIdGenre(EXPECTED_ID_GENRE);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(EXPECTED_ID_GENRE, actual.getIdGenre()),
                () -> assertEquals(EXPECTED_GENRE_NAME, actual.getNameGenre())
        );
    }

    @DisplayName("возвращает количество жанров в хранилище")
    @Test
    void shouldReturnExpectedCountGenres(){
        long actual = dao.count();
        assertEquals(actual, EXPECTED_COUNT_GENRE);
    }

    @DisplayName("обновляет указаный жанр")
    @Test
    void shouldUpdateGenre() {
        Genre updateGenre = new Genre(EXPECTED_ID_GENRE,
                GENRE_NAME_NEW,
                GENRE_DESCRIPTION_NEW);
        dao.update(updateGenre);

        Genre actual = dao.getByIdGenre(EXPECTED_ID_GENRE);

        assertAll(
                ()->assertEquals(GENRE_NAME_NEW, actual.getNameGenre()),
                ()->assertEquals(GENRE_DESCRIPTION_NEW, actual.getDescriptionGenre())
        );
    }

    @DisplayName("создает новый жанр")
    @Test
    void shouldInsertGenre() {
        Genre newGenre = new Genre();
        newGenre.setNameGenre(GENRE_NAME_NEW);
        newGenre.setDescriptionGenre(GENRE_DESCRIPTION_NEW);

        long actualId = dao.addGenre(newGenre);
        Genre actual = dao.getByIdGenre(actualId);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(GENRE_NAME_NEW, actual.getNameGenre()),
                () -> assertEquals(GENRE_DESCRIPTION_NEW, actual.getDescriptionGenre())
        );
    }

    @DisplayName("удаляет указанный жанр")
    @Test
    void shouldDeleteGenre(){
        dao.delete(EXPECTED_ID_GENRE);
        long actual = dao.count();
        assertEquals(EXPECTED_COUNT_GENRE - 1L, actual);
    }

    @DisplayName("возвращает список жанров в хранилище")
    @Test
    void shouldExpectedReturnGenres(){
        List<Genre> genres = dao.getAllGenres();
        long actual = genres.stream().count();
        assertEquals(EXPECTED_COUNT_GENRE, actual);
    }
}
