package ru.otus.ovodkov.homework6.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.ovodkov.homework6.domain.Author;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ovodkov Sergey on 07.04.2020
 */
@DisplayName("DAO для работы с авторами книг")
@DataJpaTest
@Import(AuthorDaoJpa.class)
public class AuthorDaoJpaTest {

    @Autowired
    private AuthorDaoJpa repositoryJpa;
    @Autowired
    private TestEntityManager em;

    private static final long ID_AUTHOR = 1L;
    private static final int EXPECTED_COUNT_AUTHORS = 12;

    @DisplayName("возвращает указаного автора книги")
    @Test
    void shouldReturnExpectedAuthor() {
        Optional<Author> optionalActualAuthor = repositoryJpa.getByIdAuthor(ID_AUTHOR);
        Author expectedAuthor = em.find(Author.class, ID_AUTHOR);

        assertThat(optionalActualAuthor).isPresent().get()
                .isEqualToComparingFieldByField(expectedAuthor);
    }

    @DisplayName("возвращает всех авторов книг")
    @Test
    void shouldReturnCorrectAuthorListWithAllInfo() {
        List<Author> actualAuthors = repositoryJpa.getAllAuthor();

        assertThat(actualAuthors).isNotNull().hasSize(EXPECTED_COUNT_AUTHORS)
                .allMatch(x -> !x.getFirstName().equals(""))
                .allMatch(x -> !x.getLastName().equals(""))
                .allMatch(x -> x.getBooks() != null && x.getBooks().size() > 0);
    }

    @DisplayName("удаляем указаного автора книг")
    @Test
    void shouldDeleteBook() {
        repositoryJpa.delete(ID_AUTHOR);
        long actual = repositoryJpa.getAllAuthor().size();

        assertEquals(EXPECTED_COUNT_AUTHORS - 1, actual);
    }
}
