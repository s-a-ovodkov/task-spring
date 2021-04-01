package ru.otus.ovodkov.homework12.services;

import ru.otus.ovodkov.homework12.entities.Author;
import ru.otus.ovodkov.homework12.entities.Book;

import java.util.List;
import java.util.Set;

/**
 * Сервис работы с авторами книг
 *
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
public interface AuthorService {
  /**
   * Получить список всех авторов книг
   *
   * @return Все авторы книг
   */
  List<Author> getAuthors();

  /**
   * Получить список книг указанного автора
   *
   * @param idAuthor Идентификатор автора
   * @return Список книг автора
   */
  Set<Book> getBooksAuthor(long idAuthor);
}
