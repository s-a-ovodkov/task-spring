package ru.otus.ovodkov.homework6.services;

import ru.otus.ovodkov.homework6.domain.Book;
import ru.otus.ovodkov.homework6.domain.Genre;
import ru.otus.ovodkov.homework6.exceptions.NoEntityException;

import java.util.List;
import java.util.Set;

/**
 * Сервис жанров
 *
 * @author Ovodkov Sergey on 07.04.2020
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
    Set<Book> getBooksGenre(long idGenre) throws NoEntityException;
}
