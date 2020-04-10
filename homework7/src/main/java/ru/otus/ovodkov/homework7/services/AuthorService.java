package ru.otus.ovodkov.homework7.services;

import ru.otus.ovodkov.homework7.domain.Author;
import ru.otus.ovodkov.homework7.domain.Book;
import ru.otus.ovodkov.homework7.exceptions.NoEntityException;

import java.util.List;
import java.util.Set;

/**
 * Сервис работы с авторами книг
 *
 * @author Ovodkov Sergey on 10.04.2020
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
