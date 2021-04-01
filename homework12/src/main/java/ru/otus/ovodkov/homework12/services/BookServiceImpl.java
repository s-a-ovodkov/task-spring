package ru.otus.ovodkov.homework12.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework12.entities.Author;
import ru.otus.ovodkov.homework12.entities.Book;
import ru.otus.ovodkov.homework12.entities.Comment;
import ru.otus.ovodkov.homework12.entities.Genre;
import ru.otus.ovodkov.homework12.exceptions.NoEntityException;
import ru.otus.ovodkov.homework12.repositories.BookRepository;

import java.util.List;
import java.util.Set;

/**
 * Сервис работы с книгами
 *
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public Book getBookById(long idBook) {
    return bookRepository
        .findByIdBook(idBook)
        .orElseThrow(() -> new NoEntityException(idBook, Book.class.getName()));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Book> getBooks() {
    return bookRepository.findAll();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void delete(long idBook) {
    Book book = getBookById(idBook);
    bookRepository.delete(book);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Set<Author> getAuthorsBook(long idBook) {
    return bookRepository
        .findByIdBook(idBook)
        .orElseThrow(() -> new NoEntityException(idBook, Book.class.getName()))
        .getAuthors();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Set<Genre> getGenresBook(long idBook) {
    return bookRepository
        .findByIdBook(idBook)
        .orElseThrow(() -> new NoEntityException(idBook, Book.class.getName()))
        .getGenres();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Set<Comment> getCommentsBook(long idBook) {
    return bookRepository
        .findByIdBook(idBook)
        .orElseThrow(() -> new NoEntityException(idBook, Book.class.getName()))
        .getComments();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Book saveBook(Book book) {
    return bookRepository.save(book);
  }
}
