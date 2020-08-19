package ru.otus.ovodkov.homework8.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ovodkov Sergey
 * created on 19.08.2020
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

    @Override
    public String toString() {
        return "Book{" +
                ", titleBook = '" + title + '\'' +
                ", edition = " + edition +
                ", yearPublishing = " + yearPublishing +
                " }";
    }
}
