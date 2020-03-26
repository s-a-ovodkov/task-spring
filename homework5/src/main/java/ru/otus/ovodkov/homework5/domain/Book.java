package ru.otus.ovodkov.homework5.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Доменная модель книги
 *
 * @author Ovodkov Sergey
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    /**
     * Идентификатор книги
     */
    private long idBook;

    /**
     * Название книги
     */
    private String titleBook;

    /**
     * Номер издания
     */
    private int edition;

    /**
     * Год издания книги
     */
    private int yearPublishing;
}
