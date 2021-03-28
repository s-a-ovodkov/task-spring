package ru.otus.ovodkov.homework12.services;

import ru.otus.ovodkov.homework12.entities.Comment;

/**
 * Сервис работы с комментариями
 *
 * @author Ovodkov Sergey
 * created on 28.03.2021
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
