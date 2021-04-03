package ru.otus.ovodkov.homework7.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ovodkov Sergey on 10.04.2020
 */
@DisplayName("Доменная модель Author")
public class AuthorTest {

    private static final long ID_AUTHOR = 1L;
    private static final String FIRST_NAME = "Джозеф";
    private static final String LAST_NAME = "Албахари";
    private static final Set<Book> BOOKS = Set.of(new Book());

    @DisplayName("корректно создается конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        Author author = new Author(ID_AUTHOR, FIRST_NAME, LAST_NAME, BOOKS);

        assertAll(
                () -> Assertions.assertEquals(ID_AUTHOR, author.getIdAuthor()),
                () -> Assertions.assertEquals(FIRST_NAME, author.getFirstName()),
                () -> Assertions.assertEquals(LAST_NAME, author.getLastName()),
                () -> assertNotNull(author.getBooks())
        );
    }
}
