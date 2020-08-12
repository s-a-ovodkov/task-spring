package ru.otus.ovodkov.homework10.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.otus.ovodkov.homework10.entity.Book;
import ru.otus.ovodkov.homework10.service.BookService;

import java.util.List;

/**
 * @author Ovodkov Sergey
 * created on 11.08.2020
 */
@RequiredArgsConstructor
@Controller
public class BookController {

    private final BookService bookService;

    @GetMapping("/api/books")
    @ResponseBody
    public ResponseEntity<Integer> getCountBooks() {
        return ResponseEntity.ok(bookService.getBooks().size());
    }

    @GetMapping("/books")
    public String getBooks(Model model) {
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/book")
    public String getBook(@RequestParam("idBook") long idBook, Model model) {
        Book book = bookService.getBookById(idBook);
        model.addAttribute("book", book);
        return "book";
    }

    @PostMapping("/book/edit")
    public String saveBook(Book book, Model model) {
        Book bookSaved = bookService.saveBook(book);
        model.addAttribute("book", bookSaved);
        return "book";
    }

    @GetMapping("/book/delete")
    public String deleteBook(@RequestParam("idBook") long idBook, Model model) {
        bookService.delete(idBook);
        List<Book> books = bookService.getBooks();
        model.addAttribute("books", books);
        return "books";
    }
}
