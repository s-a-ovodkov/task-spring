package ru.otus.ovodkov.homework11.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ovodkov Sergey
 * created on 15.09.2020
 */
@Getter
@Setter
public class BookDto {
    /**
     * Название книги
     */
    private String title;

    /**
     * Номер издания
     */
    private int edition;

    /**
     * Год издания книги
     */
    private int yearPublishing;
}
