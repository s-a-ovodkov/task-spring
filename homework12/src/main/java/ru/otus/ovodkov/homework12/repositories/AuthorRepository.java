package ru.otus.ovodkov.homework12.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ovodkov.homework12.entities.Author;

import java.util.Optional;

/**
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

  /**
   * Поиск автора по идентификатору
   *
   * @param idAuthor Идентификатор автора
   * @return Искомый автор
   */
  @EntityGraph(value = "authorEntityGraph")
  Optional<Author> findByIdAuthor(long idAuthor);
}
