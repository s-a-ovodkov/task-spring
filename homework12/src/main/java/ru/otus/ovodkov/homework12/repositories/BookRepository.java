package ru.otus.ovodkov.homework12.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ovodkov.homework12.entities.Book;

import java.util.Optional;

/**
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
public interface BookRepository extends JpaRepository<Book, Long> {

  /**
   * Поиск книги по идентификатору
   *
   * @param idBook Идентификатор книги
   * @return Искомая книга
   */
  @EntityGraph(value = "bookEntityGraph")
  Optional<Book> findByIdBook(long idBook);
}
