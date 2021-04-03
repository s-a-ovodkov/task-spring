package ru.otus.ovodkov.homework7.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ovodkov.homework7.domain.Book;

import java.util.Optional;

/**
 * Репозиторий книги
 *
 * @author Ovodkov Sergey on 10.04.2020
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * Поиск книги по индетификатору
     *
     * @param idBook Идентификатор книги
     * @return Искомая книга
     */
    @EntityGraph(value = "bookEntityGraph")
    Optional<Book> findByIdBook(long idBook);
}
