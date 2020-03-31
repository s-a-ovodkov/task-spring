package ru.otus.ovodkov.homework5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Доменная модель Author")
public class AuthorTest {

    public static final long ID_AUTHOR = 1L;
    public static final String FIRST_NAME = "Рауль-Габриэль";
    public static final String LAST_NAME = "Урма";

    @DisplayName("корректно создается конструктором")
    @Test
    public void shouldHaveCorrectConstructor() {
        Author author = new Author(ID_AUTHOR, FIRST_NAME, LAST_NAME);

        assertAll(
                () -> assertEquals(ID_AUTHOR, author.getIdAuthor()),
                () -> assertEquals(FIRST_NAME, author.getFirstName()),
                () -> assertEquals(LAST_NAME, author.getLastName())
        );
    }
}
