package ru.otus.ovodkov.homework8.service;

import ru.otus.ovodkov.homework8.document.Book;

import java.util.List;

/**
 * Сервис работы с книгами в библиотеки
 *
 * @author Ovodkov Sergey on 11.08.2020
 */
public interface BookService {

    /**
     * Получить список книг хранящихся в библиотеки
     *
     * @return Список книг в библиотеки
     */
    List<Book> getBooks();
}
