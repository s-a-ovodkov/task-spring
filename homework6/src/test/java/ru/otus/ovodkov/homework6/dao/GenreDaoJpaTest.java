package ru.otus.ovodkov.homework6.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.otus.ovodkov.homework6.domain.Book;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@DisplayName("DAO по работе с жанрами")
@DataJpaTest
@Import(GenreDaoJpa.class)
public class GenreDaoJpaTest {

    @Autowired
    private GenreDaoJpa repositoryJpa;

    private static final long ID_GENRE = 1L;
    private static final int EXPECTED_BOOKS = 5;

    @DisplayName("возвращает книги указаного жанра")
    @Test
    void showExpectedReturnBooksByIdGenre() {
        Set<Book> actual = repositoryJpa.getBooksByIdGenre(ID_GENRE);

        assertThat(actual).isNotNull().hasSize(EXPECTED_BOOKS)
                .allMatch(x -> !x.getTitleBook().equals(""))
                .allMatch(x -> x.getEdition() != 0)
                .allMatch(x -> x.getYearPublishing() != 0)
                .allMatch(x -> x.getComments() != null && x.getComments().size() > 0)
                .allMatch(x -> x.getAuthors() != null && x.getAuthors().size() > 0)
                .allMatch(x -> x.getGenres() != null && x.getGenres().size() > 0);
    }
}
