package ru.otus.ovodkov.homework11.service;

import reactor.core.publisher.Flux;
import ru.otus.ovodkov.homework11.document.Author;
import ru.otus.ovodkov.homework11.dto.BookDto;
import ru.otus.ovodkov.homework11.exceptions.NoDocumentException;

import java.util.List;

/**
 * Сервис для работы с авторами книг
 *
 * @author Ovodkov Sergey
 * created on 15.09.2020
 */
public interface AuthorService {

    /**
     * Получить список всех авторов книг
     *
     * @return Все авторы книг
     */
    Flux<Author> getAuthors();

    /**
     * Получить список книг указанного автора
     *
     * @param authorId Идентификатор автора
     * @return Список книг автора
     * @throws NoDocumentException
     */
    List<BookDto> getBooksAuthor(String authorId) throws NoDocumentException;
}
