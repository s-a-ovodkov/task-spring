package ru.otus.ovodkov.homework8.service;

import ru.otus.ovodkov.homework8.document.Comment;
import ru.otus.ovodkov.homework8.exceptions.NoDocumentException;

import java.util.List;

/**
 * @author Ovodkov Sergey
 * created on 19.08.2020
 */
public interface CommentService {

    /**
     * Получить все комментарии
     *
     * @return Список всех комментариев
     */
    List<Comment> getComments();

    /**
     * Удалить указанный комментарий
     * @param commentId Идентификатор указанного комментария
     */
    void deleteComment(String commentId) throws NoDocumentException;
}
