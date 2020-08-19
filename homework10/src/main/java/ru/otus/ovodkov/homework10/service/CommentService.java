package ru.otus.ovodkov.homework10.service;

import ru.otus.ovodkov.homework10.entity.Comment;

/**
 * @author Ovodkov Sergey
 * created on 12.08.2020
 */
public interface CommentService {

    /**
     * Добавить новый комментарий к указаной книги
     *
     * @param idBook Идентификатор книги
     * @param text   Добавляемый комментарий
     */
    Comment addCommentBook(long idBook, String text);
}
