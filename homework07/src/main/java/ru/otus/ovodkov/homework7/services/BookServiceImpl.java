package ru.otus.ovodkov.homework7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework7.domain.Author;
import ru.otus.ovodkov.homework7.domain.Book;
import ru.otus.ovodkov.homework7.domain.Comment;
import ru.otus.ovodkov.homework7.domain.Genre;
import ru.otus.ovodkov.homework7.exceptions.NoEntityException;
import ru.otus.ovodkov.homework7.repository.BookRepository;

import java.util.List;
import java.util.Set;

/**
 * @author Ovodkov Sergey on 11.04.2020
 * @see BookService
 */
@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    /**
     * @param idBook Идентификатор книги
     * @return Искомая книга
     * @throws NoEntityException
     * @see BookService#getBookById(long)
     */
    @Override
    public Book getBookById(long idBook) throws NoEntityException {
        return bookRepository
                .findByIdBook(idBook)
                .orElseThrow(() -> new NoEntityException(idBook, Book.class.getName()));
    }

    /**
     * @return Список книг
     * @see BookService#getBooks()
     */
    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    /**
     * @param idBook Идентификатор книги
     * @throws NoEntityException
     * @see BookService#delete(long)
     */
    @Override
    public void delete(long idBook) throws NoEntityException {
        Book book = getBookById(idBook);
        bookRepository.delete(book);
    }

    /**
     * @param idBook Идентификатор книги
     * @return Список авторов выбранной книги
     * @throws NoEntityException
     * @see BookService#getAuthorsBook(long)
     */
    @Override
    public Set<Author> getAuthorsBook(long idBook) throws NoEntityException {
        return bookRepository
                .findByIdBook(idBook)
                .orElseThrow(() -> new NoEntityException(idBook, Book.class.getName()))
                .getAuthors();
    }

    /**
     * @param idBook Идентификатор книги
     * @return Список жанров выбранной книги
     * @throws NoEntityException
     * @see BookService#getGenresBook(long)
     */
    @Override
    public Set<Genre> getGenresBook(long idBook) throws NoEntityException {
        return bookRepository
                .findByIdBook(idBook)
                .orElseThrow(() -> new NoEntityException(idBook, Book.class.getName()))
                .getGenres();
    }

    /**
     * @param idBook Идентификатор книги
     * @return Список комментариев выбраной книги
     * @throws NoEntityException
     * @see BookService#getCommentsBook(long)
     */
    @Override
    public Set<Comment> getCommentsBook(long idBook) throws NoEntityException {
        return bookRepository
                .findByIdBook(idBook)
                .orElseThrow(() -> new NoEntityException(idBook, Book.class.getName()))
                .getComments();
    }
}
