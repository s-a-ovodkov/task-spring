package ru.otus.ovodkov.homework10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.otus.ovodkov.homework10.service.AuthorService;

/**
 * @author Ovodkov Sergey
 * created on 12.08.2020
 */
@RequiredArgsConstructor
@Controller
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/authors")
    public String authors() {
        return "authors";
    }

    @GetMapping("/books/author/{idAuthor}")
    public String getAuthorBooks(@PathVariable long idAuthor, Model model) {
        model.addAttribute("books", authorService.getBooksAuthor(idAuthor));
        return "books";
    }
}
