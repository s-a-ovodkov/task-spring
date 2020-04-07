package ru.otus.ovodkov.homework6.services;

import ru.otus.ovodkov.homework6.domain.Author;
import ru.otus.ovodkov.homework6.domain.Book;
import ru.otus.ovodkov.homework6.domain.Comment;
import ru.otus.ovodkov.homework6.domain.Genre;
import ru.otus.ovodkov.homework6.exceptions.NoEntityException;

import java.util.List;
import java.util.Set;

/**
 * Сервис работы с книгами
 *
 * @author Ovodkov Sergey on 07.04.2020
 */
public interface BookService {

    /**
     * Получить книгу по идентификатору
     *
     * @param idBook Идентификатор книги
     * @return Искомая книга
     */
    Book getBookById(long idBook) throws NoEntityException;

    /**
     * Получить список книг
     *
     * @return Список всех книг
     */
    List<Book> getBooks();

    /**
     * Удалить книгу по идентификатору
     *
     * @param idBook Идентификатор книги
     */
    void delete(long idBook) throws NoEntityException;

    /**
     * Получить список авторов указаной книпги
     *
     * @param idBook Идентификатор книги
     * @return Списк авторов книги
     */
    Set<Author> getAuthorsBook(long idBook) throws NoEntityException;

    /**
     * Получить список жанров указаной книги
     *
     * @param idBook Идентификатор книги
     * @return Список жанров книги
     */
    Set<Genre> getGenresBook(long idBook) throws NoEntityException;

    /**
     * Получить комментарии указаной книги
     *
     * @param idBook Идентификатор книги
     * @return Список всех комментиариев к книге
     */
    Set<Comment> getCommentsBook(long idBook) throws NoEntityException;
}
