package ru.otus.ovodkov.homework9.services;

import ru.otus.ovodkov.homework9.model.Comment;

/**
 * Сервис работы с комментариями к книгам
 *
 * @author Ovodkov Sergey
 * created on 26.04.2020
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
