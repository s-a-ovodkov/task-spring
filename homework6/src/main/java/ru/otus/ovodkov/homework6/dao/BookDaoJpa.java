package ru.otus.ovodkov.homework6.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.ovodkov.homework6.domain.Book;
import ru.otus.ovodkov.homework6.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

/**
 * @author Ovodkov Sergey
 * @see BookDao
 */
@RequiredArgsConstructor
@Transactional
@Repository
public class BookDaoJpa implements BookDao {

    @PersistenceContext
    private final EntityManager em;

    private static final String SELECT_COUNT_QUERY = "SELECT COUNT(b) FROM Book b";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM Book b WHERE b.idBook=:idBook";
    private static final String SELECT_ALL_QUERY = "SELECT b FROM Book b";

    /**
     * @return Количество книг в хранидище
     * @see BookDao#count()
     */
    @Override
    public long count() {
        return em.createQuery(SELECT_COUNT_QUERY, Long.class).getSingleResult();
    }

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
     * @param idBook Идентификатор удаляемой книги
     * @see BookDao#delete(long)
     */
    @Override
    public void delete(long idBook) {
        Query query = em.createQuery(DELETE_BY_ID_QUERY);
        query.setParameter("idBook", idBook);
        query.executeUpdate();
    }

    /**
     * @param idBook Идентификатор искомой книги
     * @return Optional с результатом поиска книги
     * @see BookDao#getByBookId(long)
     */
    @Override
    public Optional<Book> getByBookId(long idBook) {
        return Optional.ofNullable(em.find(Book.class, idBook));
    }

    /**
     * @return Список книг в хранилище
     * @see BookDao#getAllBooks()
     */
    @Override
    public List<Book> getAllBooks() {
        return em.createQuery(SELECT_ALL_QUERY, Book.class)
                .setHint("javax.persistence.fetchgraph", em.getEntityGraph("bookEntityGraph"))
                .getResultList();
    }

    /**
     * @param idBook  Идентификатор комментируемой книги
     * @param comment Добавляемый комментарий
     * @return Обновленная книга с новым комментарием
     * @see BookDao#addComment(long, Comment)
     */
    @Override
    public Optional<Book> addComment(long idBook, Comment comment) {
        Optional<Book> bookOptional = getByBookId(idBook);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.getComments().add(comment);
            return Optional.ofNullable(em.merge(book));
        } else {
            return Optional.empty();
        }
    }
}
