package ru.otus.ovodkov.homework8.service;

import ru.otus.ovodkov.homework8.document.Author;
import ru.otus.ovodkov.homework8.dto.BookDto;
import ru.otus.ovodkov.homework8.exceptions.NoDocumentException;

import java.util.List;

/**
 * Сервис для работы с авторами книг
 *
 * @author Ovodkov Sergey
 * created on 19.08.2020
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
     * @param authorId Идентификатор автора
     * @return Список книг автора
     * @throws NoDocumentException
     */
    List<BookDto> getBooksAuthor(String authorId) throws NoDocumentException;
}
