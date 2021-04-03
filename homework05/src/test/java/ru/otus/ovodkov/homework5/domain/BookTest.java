package ru.otus.ovodkov.homework5.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Доменная модель Book")
public class BookTest {

    public static final int ID_BOOK = 1;
    public static final String TITLE_BOOK = "Spring 5. Для професионалов";
    public static final int EDITION = 5;
    public static final int YEAR_PUBLISHING = 2019;

    @DisplayName("модель корректно создается конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        Book book = new Book(ID_BOOK, TITLE_BOOK, EDITION, YEAR_PUBLISHING);

        assertAll(
                () -> assertEquals(ID_BOOK, book.getIdBook()),
                () -> assertEquals(TITLE_BOOK, book.getTitleBook()),
                () -> assertEquals(EDITION, book.getEdition()),
                () -> assertEquals(YEAR_PUBLISHING, book.getYearPublishing())
        );
    }
}
