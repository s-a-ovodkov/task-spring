package ru.otus.ovodkov.homework6.services;

import ru.otus.ovodkov.homework6.domain.Author;
import ru.otus.ovodkov.homework6.domain.Book;
import ru.otus.ovodkov.homework6.exceptions.NoEntityException;

import java.util.List;
import java.util.Set;

/**
 * Сервис авторов книг
 *
 * @author Ovodkov Sergey on 07.04.2020
 */
public interface AuthorService {

    /**
     * Получить список всех авторов книг
     *
     * @return Все авторы книг
     */
    List<Author> getAuthors();

    /**
     * Получить список книг указаного автора
     *
     * @param idAuthor Идентификатор автора
     * @return Список книг автора
     * @throws NoEntityException
     */
    Set<Book> getBooksAuthor(long idAuthor) throws NoEntityException;
}
