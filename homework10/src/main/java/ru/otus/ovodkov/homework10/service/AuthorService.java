package ru.otus.ovodkov.homework10.service;

import ru.otus.ovodkov.homework10.entity.Author;
import ru.otus.ovodkov.homework10.entity.Book;

import java.util.List;
import java.util.Set;

/**
 * @author Ovodkov Sergey
 * created on 12.08.2020
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
