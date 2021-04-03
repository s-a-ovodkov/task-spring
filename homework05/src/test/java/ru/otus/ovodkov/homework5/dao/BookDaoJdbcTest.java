package ru.otus.ovodkov.homework5.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.ovodkov.homework5.domain.Book;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DAO для работы с книгами")
@JdbcTest
@Import(BookDaoJdbc.class)
public class BookDaoJdbcTest {

    @Autowired
    private BookDaoJdbc dao;

    private static final long EXPECTED_COUNT_BOOKS = 5L;
    private static final long EXPECTED_ID_BOOK = 1L;
    private static final String EXPECTED_TITLE_BOOK = "Spring 5. Для профессионалов";
    private static final int EXPECTED_EDITION_BOOK = 5;
    private static final int EXPECTED_YEAR_PUBLISHING_BOOK = 2019;
    private static final String EXPECTED_NEW_TITLE_BOOK = "Kafka Streams в действии";
    private static final int EXPECTED_NEW_EDITION = 1;
    private static final int EXPECTED_NEW_YEAR_PUBLISHING = 2019;

    @DisplayName("возвращает количество книг в хранилище")
    @Test
    void shouldReturnExpectedCountBooks() {
        long actual = dao.count();
        assertEquals(actual, EXPECTED_COUNT_BOOKS);
    }

    @DisplayName("возвращает книгу по указаному идентификатору")
    @Test
    void shouldReturnExpectedBook() {
        Book actual = dao.getByBookId(EXPECTED_ID_BOOK);
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(EXPECTED_ID_BOOK, actual.getIdBook()),
                () -> assertEquals(EXPECTED_TITLE_BOOK, actual.getTitleBook()),
                () -> assertEquals(EXPECTED_EDITION_BOOK, actual.getEdition()),
                () -> assertEquals(EXPECTED_YEAR_PUBLISHING_BOOK, actual.getYearPublishing())
        );
    }

    @DisplayName("обновляет указаную книгу")
    @Test
    void shouldUpdateBook() {
        Book newBook = new Book(EXPECTED_ID_BOOK,
                EXPECTED_NEW_TITLE_BOOK,
                EXPECTED_NEW_EDITION,
                EXPECTED_NEW_YEAR_PUBLISHING);
        dao.update(newBook);
        Book actual = dao.getByBookId(EXPECTED_ID_BOOK);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(EXPECTED_NEW_TITLE_BOOK, actual.getTitleBook()),
                () -> assertEquals(EXPECTED_NEW_EDITION, actual.getEdition()),
                () -> assertEquals(EXPECTED_NEW_YEAR_PUBLISHING, actual.getYearPublishing())
        );
    }

    @DisplayName("добавляет новую книгу в хранилище")
    @Test
    void shouldInsertBook() {
        Book newBook = new Book();
        newBook.setTitleBook(EXPECTED_NEW_TITLE_BOOK);
        newBook.setEdition(EXPECTED_NEW_EDITION);
        newBook.setYearPublishing(EXPECTED_NEW_YEAR_PUBLISHING);
        long idBook = dao.addBook(newBook);

        Book actual = dao.getByBookId(idBook);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(EXPECTED_NEW_TITLE_BOOK, actual.getTitleBook()),
                () -> assertEquals(EXPECTED_NEW_EDITION, actual.getEdition()),
                () -> assertEquals(EXPECTED_NEW_YEAR_PUBLISHING, actual.getYearPublishing())
        );
    }

    @DisplayName("удаляем указаную книгу")
    @Test
    void shouldDeleteBook() {
        dao.delete(EXPECTED_ID_BOOK);
        long actual = dao.count();
        assertEquals(EXPECTED_COUNT_BOOKS - 1L, actual);
    }

    @DisplayName("возвращает списко всех книг в хранилище")
    @Test
    void shouldExpectedReturnBooks(){
        List<Book> books = dao.getAllBooks();
        long actual = books.stream().count();
        assertEquals(EXPECTED_COUNT_BOOKS, actual);
    }
}
