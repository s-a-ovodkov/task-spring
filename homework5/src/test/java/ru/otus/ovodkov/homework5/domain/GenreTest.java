package ru.otus.ovodkov.homework5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Доменная модель Genre")
public class GenreTest {

    public static final long ID_GENRE = 1L;
    public static final String NAME_GENRE = "Java";
    public static final String DESCRIPTION_GENRE = "Самые лучшие книги";

    @DisplayName("корректно создается конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        Genre genre = new Genre(ID_GENRE, NAME_GENRE, DESCRIPTION_GENRE);

        assertAll(
                () -> assertEquals(ID_GENRE, genre.getIdGenre()),
                () -> assertEquals(NAME_GENRE, genre.getNameGenre()),
                () -> assertEquals(DESCRIPTION_GENRE, genre.getDescriptionGenre())
        );
    }
}
