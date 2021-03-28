package ru.otus.ovodkov.homework12.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.ovodkov.homework12.entities.Author;
import ru.otus.ovodkov.homework12.entities.Book;
import ru.otus.ovodkov.homework12.services.AuthorService;

import java.util.List;
import java.util.Set;

/**
 * Работа с авторами книг
 *
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
@RequiredArgsConstructor
@Controller
public class AuthorController {

  private final AuthorService authorService;

  @GetMapping("/authors")
  public String getAuthors(Model model){
    List<Author> authors = authorService.getAuthors();
    model.addAttribute("authors", authors);
    return "authors";
  }

  @GetMapping("/books/author")
  public String getAuthorBooks(@RequestParam("idAuthor") long idAuthor, Model model) {
    Set<Book> books = authorService.getBooksAuthor(idAuthor);
    model.addAttribute("books", books);
    return "books";
  }
}
