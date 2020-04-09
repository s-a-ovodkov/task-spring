package ru.otus.ovodkov.homework6.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.ovodkov.homework6.domain.Genre;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("DAO по работе с жанрами")
@DataJpaTest
@Import(GenreDaoJpa.class)
public class GenreDaoJpaTest {

    @Autowired
    private GenreDaoJpa repositoryJpa;

    @Autowired
    private TestEntityManager em;

    private static final long ID_GENRE = 1L;
    private static final int EXPECTED_CONT_GENRES = 2;

    @DisplayName("возвращает жанр по идентификатору")
    @Test
    void shouldReturnExpectedGenre() {
        Optional<Genre> optionalActualGenre = repositoryJpa.getByIdGenre(ID_GENRE);
        Genre expectedGenre = em.find(Genre.class, ID_GENRE);

        assertThat(optionalActualGenre).isPresent().get()
                .isEqualToComparingFieldByField(expectedGenre);
    }

    @DisplayName("удаляет жанр по указаному идентификатору")
    @Test
    void shouldDeleteGenre() {
        repositoryJpa.delete(ID_GENRE);
        long actual = repositoryJpa.getAllGenre().size();

        assertEquals(EXPECTED_CONT_GENRES - 1, actual);
    }

    @DisplayName("получаем список всех жанров")
    @Test
    void shouldReturnCorrectGenreListWithAllInfo() {
        List<Genre> actualList = repositoryJpa.getAllGenre();

        assertThat(actualList).isNotNull().hasSize(EXPECTED_CONT_GENRES)
                .allMatch(x -> !x.getNameGenre().equals(""))
                .allMatch(x -> !x.getDescriptionGenre().equals(""))
                .allMatch(x -> x.getBooks() != null && x.getBooks().size() > 0);
    }
}
