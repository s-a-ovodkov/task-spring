package ru.otus.ovodkov.homework6.dao;

import ru.otus.ovodkov.homework6.domain.Comment;

import java.util.List;
import java.util.Optional;

/**
 * DAO для взаимодействия с комментариями в БД
 *
 * @author Ovodkov Sergey
 */
public interface CommentDao {

    /**
     * Сохранение или добавление коментария
     *
     * @param comment Обновляемый или сохраняемый комментарий
     * @return Обновленный комментарий
     */
    Comment save(Comment comment);

    /**
     * Удаление комментария по идентификатору
     *
     * @param idComment Идентификатор комментария
     */
    void delete(long idComment);

    /**
     * Получение комментария по идентификатору
     *
     * @param idComment Идентификатор комментария
     * @return Искомы комментарий
     */
    Optional<Comment> getByIdComment(long idComment);

    /**
     * Получить все комментария в базе
     *
     * @return Все комментарии
     */
    List<Comment> getAllComments();
}
