package ru.otus.ovodkov.homework12.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.ovodkov.homework12.entities.Book;
import ru.otus.ovodkov.homework12.entities.Genre;
import ru.otus.ovodkov.homework12.services.GenreService;

import java.util.List;
import java.util.Set;

/**
 * Работа с жанрами книг
 *
 * @author Ovodkov Sergey
 * created on 28.03.2021
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
  public String getGenreBooks(@RequestParam("idGenre") long idGenre, Model model) {
    Set<Book> books = genreService.getBooksGenre(idGenre);
    model.addAttribute("books", books);
    return "books";
  }
}
