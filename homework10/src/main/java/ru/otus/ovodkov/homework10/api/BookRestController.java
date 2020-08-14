package ru.otus.ovodkov.homework10.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.ovodkov.homework10.service.BookService;

/**
 * @author Ovodkov Sergey
 * created on 14.08.2020
 */
@RequiredArgsConstructor
@RestController
public class BookRestController {

    private final BookService bookService;

    @GetMapping("/api/books")
    @ResponseBody
    public ResponseEntity<Integer> getCountBooks() {
        return ResponseEntity.ok(bookService.getBooks().size());
    }
}
