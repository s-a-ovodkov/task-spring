package ru.otus.ovodkov.homework6.dao;

import ru.otus.ovodkov.homework6.domain.Book;
import ru.otus.ovodkov.homework6.domain.Comment;

import java.util.List;
import java.util.Optional;

/**
 * Взаимодействие с хранилищем книг
 *
 * @author Ovodkov Sergey
 */
public interface BookDao {

    /**
     * Добавить книгу в хранилище
     *
     * @param book Добавляемая книга
     * @return Идентификатор добавленной книги
     */
    Book save(Book book);

    /**
     * Удалить книгу
     *
     * @param book Удаляемая книга
     */
    void delete(Book book);

    /**
     * Получить книгу
     *
     * @param idBook Идентификатор искомой книги
     * @return Данные книги
     */
    Optional<Book> getByBookId(long idBook);

    /**
     * Получить список всех книг
     *
     * @return Список книг в хранилище
     */
    List<Book> getAllBooks();
}
