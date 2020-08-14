package ru.otus.ovodkov.homework10.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.ovodkov.homework10.entity.Author;
import ru.otus.ovodkov.homework10.service.AuthorService;

import java.util.List;

/**
 * @author Ovodkov Sergey
 * created on 14.08.2020
 */
@RequiredArgsConstructor
@RestController
public class AuthorRestController {

    private final AuthorService authorService;

    /**
     * Получение списка авторов книг
     * @return Список авторов книг
     */
    @GetMapping("/api/authors/")
    @ResponseBody
    public ResponseEntity<List<Author>> getAuthors() {
        return ResponseEntity.ok(authorService.getAuthors());
    }
}
