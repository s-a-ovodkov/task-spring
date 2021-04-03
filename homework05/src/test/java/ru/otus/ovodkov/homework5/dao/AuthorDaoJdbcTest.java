package ru.otus.ovodkov.homework5.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import ru.otus.ovodkov.homework5.domain.Author;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("DAO для работы с хранилищем авторов книг")
@JdbcTest
@Import(AuthorDaoJdbc.class)
public class AuthorDaoJdbcTest {

    @Autowired
    private AuthorDaoJdbc dao;

    private static final long EXPECTED_COUNT = 12L;
    private static final long EXPECTED_ID_AUTHOR = 1L;
    private static final String EXPECTED_FIRST_NAME = "Юлиана";
    private static final String EXPECTED_LAST_NAME = "Козмина";
    private static final String EXPECTED_NEW_FIRST_NAME = "Олег";
    private static final String EXPECTED_NEW_LAST_NAME = "Докука";

    @DisplayName("возвращает количество авторов книг в хранилище")
    @Test
    void shouldReturnExpectedCountAuthors() {
        long actual = dao.count();
        assertEquals(EXPECTED_COUNT, actual);
    }

    @DisplayName("возвращает автора по идентификатору")
    @Test
    void shouldReturnExpectedAuthor() {
        Author actual = dao.getByIdAuthor(EXPECTED_ID_AUTHOR);
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(EXPECTED_ID_AUTHOR, actual.getIdAuthor()),
                () -> assertEquals(EXPECTED_FIRST_NAME, actual.getFirstName()),
                () -> assertEquals(EXPECTED_LAST_NAME, actual.getLastName())
        );
    }

    @DisplayName("добавляет нового автора")
    @Test
    void shouldInsertAuthor() {
        Author newAuthor = new Author();
        newAuthor.setFirstName(EXPECTED_NEW_FIRST_NAME);
        newAuthor.setLastName(EXPECTED_NEW_LAST_NAME);
        long idAuthor = dao.addAuthor(newAuthor);
        Author actual = dao.getByIdAuthor(idAuthor);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(EXPECTED_NEW_FIRST_NAME, actual.getFirstName()),
                () -> assertEquals(EXPECTED_NEW_LAST_NAME, actual.getLastName())
        );
    }

    @DisplayName("обновляет информацию об авторе")
    @Test
    void shouldUpdateAuthor() {
        Author newAuthor = new Author(EXPECTED_ID_AUTHOR,
                EXPECTED_NEW_FIRST_NAME,
                EXPECTED_NEW_LAST_NAME);
        dao.update(newAuthor);
        Author actual = dao.getByIdAuthor(EXPECTED_ID_AUTHOR);
        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(EXPECTED_ID_AUTHOR, actual.getIdAuthor()),
                () -> assertEquals(EXPECTED_NEW_FIRST_NAME, actual.getFirstName()),
                () -> assertEquals(EXPECTED_NEW_LAST_NAME, actual.getLastName())
        );
    }

    @DisplayName("удаляет автора из хранилища")
    @Test
    void shouldDeleteAuthors() {
        dao.delete(EXPECTED_ID_AUTHOR);
        long actual = dao.count();
        assertEquals(EXPECTED_COUNT - 1L, actual);
    }

    @DisplayName("возвращает список всех авторов")
    @Test
    void shouldExpectedReturnAuthors(){
        List<Author> authors = dao.getAllAuthors();
        long actual = authors.stream().count();
        assertEquals(EXPECTED_COUNT, actual);
    }
}
