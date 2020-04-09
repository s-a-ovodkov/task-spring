package ru.otus.ovodkov.homework6.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.ovodkov.homework6.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

/**
 * @author Ovodkov Sergey
 * @see GenreDao
 */
@RequiredArgsConstructor
@Repository
public class GenreDaoJpa implements GenreDao {

    public static final String SELECT_BY_ID_QUERY = "SELECT g FROM Genre g WHERE g.idGenre=:idGenre";
    @PersistenceContext
    private final EntityManager em;

    private static final String DELETE_BY_ID_QUERY = "DELETE FROM Genre g WHERE g.idGenre=:idGenre";
    private static final String SELECT_ALL_QUERY = "SELECT g FROM Genre g";

    /**
     * @param genre Обновляемый или добавляемый жанр
     * @return Обновленный жанр
     * @see GenreDao#save(Genre)
     */
    @Override
    public Genre save(Genre genre) {
        if (genre.getIdGenre() <= 0) {
            em.persist(genre);
            return genre;
        } else {
            return em.merge(genre);
        }
    }

    /**
     * @param idGenre Идентификатор жанра
     * @see GenreDao#delete(long)
     */
    @Override
    public void delete(long idGenre) {
        Query query = em.createQuery(DELETE_BY_ID_QUERY);
        query.setParameter("idGenre", idGenre);
        query.executeUpdate();
    }

    /**
     * @param idGenre Идентификатор жанра
     * @return Данные о жанре
     * @see GenreDao#getByIdGenre(long)
     */
    @Override
    public Optional<Genre> getByIdGenre(long idGenre) {
        return Optional.ofNullable(em.createQuery(SELECT_BY_ID_QUERY, Genre.class)
                .setParameter("idGenre", idGenre)
                .setHint("javax.persistence.fetchgraph", em.getEntityGraph("genreEntityGraph"))
                .getSingleResult());
    }

    /**
     * @return Список всех жанров
     * @see GenreDao#getAllGenre()
     */
    @Override
    public List<Genre> getAllGenre() {
        return em.createQuery(SELECT_ALL_QUERY, Genre.class)
                .getResultList();
    }
}
