package ru.otus.ovodkov.homework8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework8.document.Author;
import ru.otus.ovodkov.homework8.document.Book;
import ru.otus.ovodkov.homework8.document.Comment;
import ru.otus.ovodkov.homework8.document.Genre;
import ru.otus.ovodkov.homework8.dto.AuthorDto;
import ru.otus.ovodkov.homework8.exceptions.NoDocumentException;
import ru.otus.ovodkov.homework8.repository.BookRepository;

import java.util.List;

/**
 * {@inheritDoc}
 *
 * @author Ovodkov Sergey on 11.08.2020
 */
@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

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
    public Book getBookById(String bookId) throws NoDocumentException {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new NoDocumentException(bookId, Book.class.getName()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void delete(String bookId) throws NoDocumentException {
        Book book = getBookById(bookId);
        bookRepository.delete(book);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<AuthorDto> getAuthorsBook(String bookId) throws NoDocumentException {
        return getBookById(bookId).getAuthors();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getGenresBook(String bookId) throws NoDocumentException {
        return getBookById(bookId).getGenres();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Comment> getCommentsBook(String bookId) throws NoDocumentException {
        return getBookById(bookId).getComments();
    }
}
