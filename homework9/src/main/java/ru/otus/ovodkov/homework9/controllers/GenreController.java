package ru.otus.ovodkov.homework9.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.ovodkov.homework9.model.Book;
import ru.otus.ovodkov.homework9.model.Genre;
import ru.otus.ovodkov.homework9.services.GenreService;

import java.util.List;
import java.util.Set;

/**
 * @author Ovodkov Sergey
 * created on 07.05.2020
 */
@RequiredArgsConstructor
@Controller
public class GenreController {

    private final GenreService genreService;

    @GetMapping("/genres")
    public String getGenres(Model model) {
        List<Genre> genres = genreService.getGenres();
        model.addAttribute("genres", genres);
        return "genres";
    }

    @GetMapping("/books/genre")
    public String getGenreBooks(@RequestParam("idGenre") int idGenre, Model model) {
        Set<Book> books = genreService.getBooksGenre(idGenre);
        model.addAttribute("books", books);
        return "books";
    }
}
