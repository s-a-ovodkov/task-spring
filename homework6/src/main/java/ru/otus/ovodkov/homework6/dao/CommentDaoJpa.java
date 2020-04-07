package ru.otus.ovodkov.homework6.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.ovodkov.homework6.domain.Comment;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

/**
 * @author Ovodkov Sergey
 * @see CommentDao
 */
@RequiredArgsConstructor
@Transactional
@Repository
public class CommentDaoJpa implements CommentDao {

    @PersistenceContext
    private final EntityManager em;

    private static final String SELECT_ALL_QUERY = "SELECT c FROM Comment c";
    private static final String DELETE_BY_ID_QUERY = "DELETE FROM Comment c WHERE c.idComment=:idComment";

    /**
     * @param comment Обновляемый или сохраняемый комментарий
     * @return Обновленный жанр
     * @see CommentDao#save(Comment)
     */
    @Override
    public Comment save(Comment comment) {
        if (comment.getIdComment() <= 0) {
            em.persist(comment);
            return comment;
        } else {
            return em.merge(comment);
        }
    }

    /**
     * @param idComment Идентификатор комментария
     * @see CommentDao#delete(long)
     */
    @Override
    public void delete(long idComment) {
        Query query = em.createQuery(DELETE_BY_ID_QUERY);
        query.setParameter("idComment", idComment);
        query.executeUpdate();
    }

    /**
     * @param idComment Идентификатор комментария
     * @return Искомый комментарий
     * @see CommentDao#getByIdComment(long)
     */
    @Override
    public Optional<Comment> getByIdComment(long idComment) {
        return Optional.ofNullable(em.find(Comment.class, idComment));
    }

    /**
     * @return Все имеющие комментарии
     * @see CommentDao#getAllComments()
     */
    @Override
    public List<Comment> getAllComments() {
        return em.createQuery(SELECT_ALL_QUERY, Comment.class)
                .getResultList();
    }
}
