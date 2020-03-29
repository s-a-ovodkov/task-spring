package ru.otus.ovodkov.homework5.dao;

import ru.otus.ovodkov.homework5.domain.Author;

import java.util.List;
import java.util.Optional;

/**
 * Взаимодействие с хранилищем авторов
 *
 * @author Ovodkov Sergey
 */
public interface AuthorDao {

    /**
     * Получить количество авторов в хранилище
     * @return Количество авторов в хранилище
     */
    long count();

    /**
     * Добавить автора в хранилища
     *
     * @param author Добавляемый автор
     * @return Идентификатор автора
     */
    long addAuthor(Author author);

    /**
     * Обновить данные автора
     *
     * @param author Новые данные автора
     */
    void update(Author author);

    /**
     * Удалить автора
     *
     * @param idAuthor Идентификатор удаляемого автора
     */
    void delete(long idAuthor);

    /**
     * Получить данные автора
     *
     * @param idAuthor Идентификатор автора
     * @return Данные автора
     */
    Author getByIdAuthor(long idAuthor);

    /**
     * Получить список всех авторов
     *
     * @return Список всех авторов
     */
    List<Author> getAllAuthors();
}
