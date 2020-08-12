package ru.otus.ovodkov.homework10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.otus.ovodkov.homework10.entity.Genre;
import ru.otus.ovodkov.homework10.service.GenreService;

import java.util.List;

/**
 * @author Ovodkov Sergey
 * created on 12.08.2020
 */
@RequiredArgsConstructor
@Controller
public class GenresController {

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

    @GetMapping("/genres")
    public String genres() {
        return "genres";
    }

    @GetMapping("/books/genre/{idGenre}")
    public String getGenreBooks(@PathVariable long idGenre, Model model) {
        model.addAttribute("books", genreService.getBooksGenre(idGenre));
        return "books";
    }
}
