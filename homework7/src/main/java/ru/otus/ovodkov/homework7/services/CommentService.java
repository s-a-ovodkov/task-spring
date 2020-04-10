package ru.otus.ovodkov.homework7.services;

import ru.otus.ovodkov.homework7.domain.Comment;
import ru.otus.ovodkov.homework7.exceptions.NoEntityException;

/**
 * Сервис работы с комментариями
 *
 * @author Ovodkov Sergey on 11.04.2020
 */
public interface CommentService {

    /**
     * Добавить новый комментарий к указаной книги
     *
     * @param idBook Идентификатор книги
     * @param text   Добавляемый комментарий
     * @throws NoEntityException
     */
    Comment addCommentBook(long idBook, String text) throws NoEntityException;
}
