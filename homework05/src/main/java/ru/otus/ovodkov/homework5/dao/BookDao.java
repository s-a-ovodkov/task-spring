package ru.otus.ovodkov.homework5.dao;

import ru.otus.ovodkov.homework5.domain.Book;

import java.util.List;

/**
 * Взаимодействие с хранилищем книг
 *
 * @author Ovodkov Sergey
 */
public interface BookDao {
    /**
     * Получить количество книг в хранилище
     * @return Количество книг в хранилище
     */
    long count();

    /**
     * Добавить книгу в хранилище
     *
     * @param book Добавляемая книга
     * @return Идентификатор добавленной книги
     */
    long addBook(Book book);

    /**
     * Обновить данные книги
     *
     * @param book Обновленные данные книги
     */
    void update(Book book);

    /**
     * Удалить книгу
     *
     * @param idBook Идентификатор удаляемой книги
     */
    void delete(long idBook);

    /**
     * Получить книгу
     *
     * @param idBook Идентификатор искомой книги
     * @return Данные книги
     */
    Book getByBookId(long idBook);

    /**
     * Получить список всех книг
     *
     * @return Список книг в хранилище
     */
    List<Book> getAllBooks();
}
