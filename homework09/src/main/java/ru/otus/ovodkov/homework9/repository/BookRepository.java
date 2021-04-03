package ru.otus.ovodkov.homework9.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ovodkov.homework9.model.Book;

import java.util.Optional;

/**
 * Репозиторий книг
 *
 * @author Ovodkov Sergey
 * created on 26.04.2020
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
