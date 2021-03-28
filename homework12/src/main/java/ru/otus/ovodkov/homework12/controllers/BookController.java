package ru.otus.ovodkov.homework12.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.otus.ovodkov.homework12.entities.Book;
import ru.otus.ovodkov.homework12.services.BookService;

import java.util.List;

/**
 * Работа с книгами
 *
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
@RequiredArgsConstructor
@Controller
public class BookController {

  private final BookService bookService;

  @GetMapping("/")
  public String index(Model model) {
    int booksCount = bookService.getBooks().size();
    model.addAttribute("booksCount", booksCount);
    return "index";
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
