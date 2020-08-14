package ru.otus.ovodkov.homework10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.ovodkov.homework10.service.GenreService;

/**
 * @author Ovodkov Sergey
 * created on 12.08.2020
 */
@RequiredArgsConstructor
@Controller
public class GenreController {

    public final GenreService genreService;

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
