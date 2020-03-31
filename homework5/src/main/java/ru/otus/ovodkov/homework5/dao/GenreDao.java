package ru.otus.ovodkov.homework5.dao;

import ru.otus.ovodkov.homework5.domain.Genre;

import java.util.List;

/**
 * Взаимодействие с хранилищем жанров
 *
 * @author Ovodkov Sergey
 */
public interface GenreDao {

    /**
     * Количество записей в хранилище
     * @return Количество жанров в хранилище
     */
    long count();

    /**
     * Добавить жанр
     *
     * @param genre Добавляемый жанр
     * @return Идентификатор добавленного жанра
     */
    long addGenre(Genre genre);

    /**
     * Обновить данные жанра
     *
     * @param genre Обновляемые данные жанра
     */
    void update(Genre genre);

    /**
     * Удалить жанр
     *
     * @param idGenre Идентификатор удаляемого жанра
     */
    void delete(long idGenre);

    /**
     * Получить данные жанра
     *
     * @param idGenre Идентификатор искомого жанра
     * @return Данные жанра
     */
    Genre getByIdGenre(long idGenre);

    /**
     * Получить список всех жанров
     *
     * @return Список жанров
     */
    List<Genre> getAllGenres();
}
