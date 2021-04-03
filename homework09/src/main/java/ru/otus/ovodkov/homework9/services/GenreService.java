package ru.otus.ovodkov.homework9.services;

import ru.otus.ovodkov.homework9.model.Book;
import ru.otus.ovodkov.homework9.model.Genre;

import java.util.List;
import java.util.Set;

/**
 * Сервис работы с жанрами книг
 *
 * @author Ovodkov Sergey
 * created on 26.04.2020
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
