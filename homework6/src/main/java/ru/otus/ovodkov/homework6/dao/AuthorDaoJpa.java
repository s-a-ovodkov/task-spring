package ru.otus.ovodkov.homework6.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.ovodkov.homework6.domain.Author;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

/**
 * @author Ovodkov Sergey on 07.04.2020
 * @see AuthorDao
 */
@RequiredArgsConstructor
@Transactional
@Repository
public class AuthorDaoJpa implements AuthorDao {

    @Autowired
    private final EntityManager em;

    private static final String DELETE_BY_ID_QUERY = "DELETE FROM Author a WHERE a.idAuthor=:idAuthor";
    private static final String SELECT_ALL_QUERY = "SELECT a FROM Author a";
    private static final String SELECT_BY_ID_QUERY = "SELECT a FROM Author a WHERE a.idAuthor=:idAuthor";

    /**
     * @param author Данные автора
     * @return Обновленный автор
     * @see AuthorDao#save(Author)
     */
    @Override
    public Author save(Author author) {
        if (author.getIdAuthor() <= 0) {
            em.persist(author);
            return author;
        } else {
            return em.merge(author);
        }
    }

    /**
     * @param idAuthor Идентификатор автоара
     * @see AuthorDao#delete(long)
     */
    @Override
    public void delete(long idAuthor) {
        Query query = em.createQuery(DELETE_BY_ID_QUERY);
        query.setParameter("idAuthor", idAuthor);
        query.executeUpdate();
    }

    /**
     * @param idAuthor Идентификатор автора
     * @return Искомый автор
     * @see AuthorDao#getByIdAuthor(long)
     */
    @Override
    public Optional<Author> getByIdAuthor(long idAuthor) {
        return Optional.ofNullable(em.createQuery(SELECT_BY_ID_QUERY, Author.class)
                .setParameter("idAuthor", idAuthor)
                .setHint("javax.persistence.fetchgraph", em.getEntityGraph("authorEntityGraph"))
                .getSingleResult());
    }

    /**
     * @return Список всех авторов
     * @see AuthorDao#getAllAuthor()
     */
    @Override
    public List<Author> getAllAuthor() {
        return em.createQuery(SELECT_ALL_QUERY, Author.class)
                .getResultList();
    }
}
