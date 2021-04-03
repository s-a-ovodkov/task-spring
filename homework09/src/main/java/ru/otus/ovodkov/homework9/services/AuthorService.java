package ru.otus.ovodkov.homework9.services;

import ru.otus.ovodkov.homework9.model.Author;
import ru.otus.ovodkov.homework9.model.Book;

import java.util.List;
import java.util.Set;

/**
 * Сервис работы с авторами книг
 *
 * @author Ovodkov Sergey
 * created on 26.04.2020
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
