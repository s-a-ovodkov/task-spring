package ru.otus.ovodkov.homework9.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ovodkov.homework9.model.Author;

import java.util.Optional;

/**
 * Репозиторий авторов книг
 *
 * @author Ovodkov Sergey
 * created on 26.04.2020
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
