package ru.otus.ovodkov.homework8.service;

import ru.otus.ovodkov.homework8.document.Book;
import ru.otus.ovodkov.homework8.document.Comment;
import ru.otus.ovodkov.homework8.dto.AuthorDto;
import ru.otus.ovodkov.homework8.exceptions.NoDocumentException;

import java.util.List;

/**
 * Сервис работы с книгами в библиотеки
 *
 * @author Ovodkov Sergey on 11.08.2020
 */
public interface BookService {

    /**
     * Получить список книг хранящихся в библиотеки
     *
     * @return Список книг в библиотеки
     */
    List<Book> getBooks();

    /**
     * Получения книги с указанным идентификатором
     *
     * @param bookId идентификатор искомой книги
     * @return книга с указанным идентификатором
     * @throws NoDocumentException доменное исключение для случая когда искомая книга не найдена
     */
    Book getBookById(String bookId) throws NoDocumentException;

    /**
     * Удалить книгу по идентификатору
     *
     * @param bookId Идентификатор книги
     * @throws NoDocumentException доменное исключение для случая когда искомая книга не найдена
     */
    void delete(String bookId) throws NoDocumentException;

    /**
     * Получить список авторов указанной книги
     *
     * @param bookId Идентификатор книги
     * @return Список авторов книги
     * @throws NoDocumentException доменное исключение для случая когда искомая книга не найдена
     */
    List<AuthorDto> getAuthorsBook(String bookId) throws NoDocumentException;

    /**
     * Получить список жанров указанной книги
     *
     * @param bookId Идентификатор книги
     * @return Список жанров книги
     * @throws NoDocumentException доменное исключение для случая когда искомая книга не найдена
     */
    List<String> getGenresBook(String bookId) throws NoDocumentException;

    /**
     * Получить комментарии указанной книги
     *
     * @param bookId Идентификатор книги
     * @return Список всех комментариев к книге
     * @throws NoDocumentException доменное исключение для случая когда искомая книга не найдена
     */
    List<Comment> getCommentsBook(String bookId) throws NoDocumentException;
}
