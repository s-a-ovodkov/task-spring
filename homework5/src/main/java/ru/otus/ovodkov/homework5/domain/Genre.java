package ru.otus.ovodkov.homework5.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Доменная модель описывающая жанр книги
 *
 * @author Ovodkov Sergey
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Genre {
    /**
     * Идентификатор жанра
     */
    private long idGenre;

    /**
     * Название жанра
     */
    private String nameGenre;

    /**
     * Описание жанра
     */
    private String descriptionGenre;
}
