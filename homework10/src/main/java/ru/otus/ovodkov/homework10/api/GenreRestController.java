package ru.otus.ovodkov.homework10.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.otus.ovodkov.homework10.entity.Genre;
import ru.otus.ovodkov.homework10.service.GenreService;

import java.util.List;

/**
 * @author Ovodkov Sergey
 * created on 14.08.2020
 */
@RequiredArgsConstructor
@RestController
public class GenreRestController {

    public final GenreService genreService;

    /**
     * Получить список жанров книг в библиотеки
     * @return Список жанров книг в библиотеки
     */
    @GetMapping("/api/genres/")
    @ResponseBody
    public ResponseEntity<List<Genre>> getGenres() {
        return ResponseEntity.ok(genreService.getGenres());
    }
}
