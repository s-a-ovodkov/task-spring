package ru.otus.ovodkov.homework10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.ovodkov.homework10.entity.Book;
import ru.otus.ovodkov.homework10.service.BookService;

import java.util.List;

/**
 * @author Ovodkov Sergey
 * created on 11.08.2020
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    /**
     * Получения числа книг в библиотеки
     * @return Число книг в библиотеки
     */
    @GetMapping("/count")
    public ResponseEntity<Integer> getCountBooks(){
        return ResponseEntity.ok(bookService.getBooks().size());
    }

    /**
     * Метод получения списка книг хранящихся в библиотеки
     * @return Список книг в библиотеки
     */
    @GetMapping("/")
    public ResponseEntity<List<Book>> getBooks(){
        return ResponseEntity.ok(bookService.getBooks());
    }
}
