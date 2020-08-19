package ru.otus.ovodkov.homework10.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework10.entity.Author;
import ru.otus.ovodkov.homework10.entity.Book;
import ru.otus.ovodkov.homework10.entity.Comment;
import ru.otus.ovodkov.homework10.entity.Genre;
import ru.otus.ovodkov.homework10.exception.NoEntityException;
import ru.otus.ovodkov.homework10.repository.BookRepository;

import java.util.List;
import java.util.Set;

/**
 * @author Ovodkov Sergey
 * created on 11.08.2020
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
