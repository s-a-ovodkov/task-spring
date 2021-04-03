package ru.otus.ovodkov.homework7.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ovodkov Sergey on 10.04.2020
 */
@DisplayName("Доменная модель Book")
public class BookTest {

    private static final long ID_BOOK = 1L;
    private static final String TITLE_BOOK = "C# 6.0. Справочник";
    private static final int EDITION = 6;
    private static final int YEAR_PUBLISHING = 2017;
    public static final Set<Comment> COMMENTS = Set.of(new Comment());
    public static final Set<Author> AUTHORS = Set.of(new Author());
    public static final Set<Genre> GENRES = Set.of(new Genre());

    @DisplayName("корректно создается конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        Book book = new Book(ID_BOOK, TITLE_BOOK, EDITION, YEAR_PUBLISHING, COMMENTS, AUTHORS, GENRES);

        assertAll(
                () -> assertEquals(ID_BOOK, book.getIdBook()),
                () -> assertEquals(TITLE_BOOK, book.getTitleBook()),
                () -> assertEquals(EDITION, book.getEdition()),
                () -> assertEquals(YEAR_PUBLISHING, book.getYearPublishing()),
                () -> assertNotNull(book.getComments()),
                () -> assertNotNull(book.getAuthors()),
                () -> assertNotNull(book.getGenres())
        );
    }
}
