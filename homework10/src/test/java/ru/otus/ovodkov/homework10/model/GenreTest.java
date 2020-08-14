package ru.otus.ovodkov.homework10.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.ovodkov.homework10.entity.Book;
import ru.otus.ovodkov.homework10.entity.Genre;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ovodkov Sergey
 * created on 12.08.2020
 */
@DisplayName("Доменная модель Genre")
public class GenreTest {

    private static final long ID_GENRE = 1L;
    private static final String NAME_GENRE = "C#";
    private static final String DESCRIPTION_GENRE = "Тоже не плохой язык программирования";
    private static final Set<Book> BOOKS = Set.of(new Book());

    @DisplayName("корректно создается конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        Genre genre = new Genre(ID_GENRE, NAME_GENRE, DESCRIPTION_GENRE, BOOKS);

        assertAll(
                () -> assertEquals(ID_GENRE, genre.getIdGenre()),
                () -> assertEquals(NAME_GENRE, genre.getNameGenre()),
                () -> assertNotNull(genre.getBooks())
        );
    }
}
