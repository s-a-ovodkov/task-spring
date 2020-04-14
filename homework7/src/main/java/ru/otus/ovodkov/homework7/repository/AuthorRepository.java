package ru.otus.ovodkov.homework7.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ovodkov.homework7.domain.Author;

import java.util.Optional;


/**
 * Репозиторий для работы с авторами книг
 *
 * @author Ovodkov Sergey on 10.04.2020
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
