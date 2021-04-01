package ru.otus.ovodkov.homework12.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ovodkov.homework12.entities.Genre;

import java.util.Optional;

/**
 * @author Ovodkov Sergey
 * created on 28.03.2021
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
