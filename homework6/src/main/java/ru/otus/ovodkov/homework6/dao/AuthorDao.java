package ru.otus.ovodkov.homework6.dao;

import ru.otus.ovodkov.homework6.domain.Author;

import java.util.List;
import java.util.Optional;

/**
 * DAO для работы с авторами хранящимися в БД
 *
 * @author Ovodkov Sergey
 */
public interface AuthorDao {

    /**
     * Обновить данные автора или добавить нового автора
     *
     * @param author Данные автора
     * @return Обновленный автор
     */
    Author save(Author author);

    /**
     * Удаление автора по идентификатору
     *
     * @param idAuthor Идентификатор автоара
     */
    void delete(long idAuthor);

    /**
     * Поиск автора по идентификатору
     *
     * @param idAuthor Идентификатор автора
     * @return Искомый автор
     */
    Optional<Author> getByIdAuthor(long idAuthor);

    /**
     * Получить список всех авторов
     *
     * @return Список аторов
     */
    List<Author> getAllAuthor();
}
