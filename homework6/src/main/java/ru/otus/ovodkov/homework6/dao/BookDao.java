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
     * Получить количество книг в хранилище
     *
     * @return Количество книг в хранилище
     */
    long count();

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
     * @param idBook Идентификатор удаляемой книги
     */
    void delete(long idBook);

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

    /**
     * Добавление комментария к книге
     *
     * @param idBook  Идентификатор комментируемой книги
     * @param comment Добавляемый комментарий
     * @return Обновленная книга с новым комментарием
     */
    Optional<Book> addComment(long idBook, Comment comment);
}
