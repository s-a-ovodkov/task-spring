package ru.otus.ovodkov.homework12.services;

import ru.otus.ovodkov.homework12.entities.Book;
import ru.otus.ovodkov.homework12.entities.Genre;

import java.util.List;
import java.util.Set;

/**
 * Сервис работы с жанрами книг
 *
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
public interface GenreService {

  /**
   * Получить список жанров
   *
   * @return Список жанров
   */
  List<Genre> getGenres();

  /**
   * Получить список книг указаного жанра
   *
   * @param idGenre Идентификатор жанра
   * @return Книги выбраного жанра
   */
  Set<Book> getBooksGenre(long idGenre);
}
