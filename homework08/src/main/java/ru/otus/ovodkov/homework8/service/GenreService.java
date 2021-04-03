package ru.otus.ovodkov.homework8.service;

import ru.otus.ovodkov.homework8.document.Genre;

import java.util.List;

/**
 * Сервис для работы с жанрами
 *
 * @author Ovodkov Sergey
 * created on 19.08.2020
 */
public interface GenreService {

    /**
     * Получить список имеющихся жанров
     * @return Список жанров
     */
    List<Genre> getGenres();

    /**
     * Добавить новый жанр в справочник
     * @param genreName Наименование добавляемого жанра
     */
    void addGenres(String genreName);
}
