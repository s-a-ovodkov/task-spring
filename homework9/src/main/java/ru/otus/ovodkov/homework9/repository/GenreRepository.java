package ru.otus.ovodkov.homework9.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ovodkov.homework9.model.Genre;

import java.util.Optional;

/**
 * Репозиторий жанров книг
 *
 * @author Ovodkov Sergey
 * created on 26.04.2020
 */
public interface GenreRepository extends JpaRepository<Genre, Long> {

    /**
     * Поиск жанра по идентификатору
     *
     * @param idGenre Идентификатор жанра
     * @return Искомый жанр книг
     */
    @EntityGraph(value = "genreEntityGraph")
    Optional<Genre> findByIdGenre(long idGenre);
}
