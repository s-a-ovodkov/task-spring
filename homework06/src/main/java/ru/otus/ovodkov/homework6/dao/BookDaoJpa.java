package ru.otus.ovodkov.homework6.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.otus.ovodkov.homework6.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * @author Ovodkov Sergey
 * @see BookDao
 */
@RequiredArgsConstructor
@Repository
public class BookDaoJpa implements BookDao {

    @PersistenceContext
    private final EntityManager em;

    private static final String SELECT_ALL_QUERY = "SELECT b FROM Book b";
    private static final String SELECT_BY_ID_QUERY = "SELECT b FROM Book b WHERE b.idBook=:idBook";

    /**
     * @param book Добавляемая книга
     * @see BookDao#save(Book)
     */
    @Override
    public Book save(Book book) {
        if (book.getIdBook() <= 0) {
            em.persist(book);
            return book;
        } else {
            return em.merge(book);
        }
    }

    /**
     * @param book Удаляемая книга
     * @see BookDao#delete(Book)
     */
    @Override
    public void delete(Book book) {
        em.remove(book);
    }

    /**
     * @param idBook Идентификатор искомой книги
     * @return Optional с результатом поиска книги
     * @see BookDao#getByBookId(long)
     */
    @Override
    public Optional<Book> getByBookId(long idBook) {
        return Optional.ofNullable(em.createQuery(SELECT_BY_ID_QUERY, Book.class)
                .setParameter("idBook", idBook)
                .setHint("javax.persistence.fetchgraph", em.getEntityGraph("bookEntityGraph"))
                .getSingleResult());
    }

    /**
     * @return Список книг в хранилище
     * @see BookDao#getAllBooks()
     */
    @Override
    public List<Book> getAllBooks() {
        return em.createQuery(SELECT_ALL_QUERY, Book.class)
                .getResultList();
    }
}
