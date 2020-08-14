package ru.otus.ovodkov.homework10.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ovodkov.homework10.entity.Book;

import java.util.Optional;

/**
 * Репозиторий книг
 *
 * @author Ovodkov Sergey
 * created on 11.08.2020
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
