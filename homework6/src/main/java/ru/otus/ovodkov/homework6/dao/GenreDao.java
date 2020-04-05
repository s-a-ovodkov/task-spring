package ru.otus.ovodkov.homework6.dao;

import ru.otus.ovodkov.homework6.domain.Book;

import java.util.Set;

/**
 * DAO для работы с жанрами
 * @author Ovodkov Sergey
 */
public interface GenreDao {

    /**
     * Получить список книг указаного жанра
     * @param idGenre Идентификатор жанра
     * @return Список книг указанного жанра
     */
    Set<Book> getBooksByIdGenre(long idGenre);
}
