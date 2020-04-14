package ru.otus.ovodkov.homework7.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import ru.otus.ovodkov.homework7.domain.Genre;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Ovodkov Sergey on 10.04.2020
 */
@DisplayName("Репозиторий жанров")
@DataJpaTest
public class GenreRepositoryTest {

    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private TestEntityManager em;

    private static final long ID_GENRE = 1L;

    @DisplayName("возвращает жанр по идентификатору")
    @Test
    void shouldReturnExpectedGenre() {
        Optional<Genre> optionalActualGenre = genreRepository.findByIdGenre(ID_GENRE);
        Genre expectedGenre = em.find(Genre.class, ID_GENRE);

        assertThat(optionalActualGenre).isPresent().get()
                .isEqualToComparingFieldByField(expectedGenre);
    }
}
