package ru.otus.ovodkov.homework6.dao;

import ru.otus.ovodkov.homework6.domain.Genre;

import java.util.List;
import java.util.Optional;

/**
 * DAO для работы с жанрами
 *
 * @author Ovodkov Sergey
 */
public interface GenreDao {

    /**
     * Добавление нового жанра или обновление уже имеющегося
     *
     * @param genre Обновляемый или добавляемый жанр
     * @return Обновленный или сохарненный жанр
     */
    Genre save(Genre genre);

    /**
     * Удаление жанра по указаному идентфикатору
     *
     * @param idGenre Идентификатор жанра
     */
    void delete(long idGenre);

    /**
     * Получение жанра по идентификтору
     *
     * @param idGenre Идентификатор жанра
     * @return Данные выбранного жанра
     */
    Optional<Genre> getByIdGenre(long idGenre);

    /**
     * Получение списка всех жанров в БД
     * @return Список всех жанров
     */
    List<Genre> getAllGenre();
}
