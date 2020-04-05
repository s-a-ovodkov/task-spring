package ru.otus.ovodkov.homework6.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.ovodkov.homework6.domain.Book;
import ru.otus.ovodkov.homework6.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

/**
 * @author Ovodkov Sergey
 * @see GenreDao
 */
@RequiredArgsConstructor
@Transactional
@Repository
public class GenreDaoJpa implements GenreDao {

    @PersistenceContext
    private final EntityManager em;

    /**
     * @param idGenre Идентификатор жанра
     * @return Список книг указанного жанра
     * @see GenreDao#getBooksByIdGenre(long)
     */
    @Override
    public Set<Book> getBooksByIdGenre(long idGenre) {
        Genre genre = em.createQuery("SELECT g FROM Genre g WHERE g.idGenre=:idGenre", Genre.class)
                .setParameter("idGenre", idGenre)
                .setHint("javax.persistence.fetchgraph", em.getEntityGraph("genreEntityGraph"))
                .getSingleResult();
        return genre != null
                ? genre.getBooks()
                : Set.of();
    }
}
