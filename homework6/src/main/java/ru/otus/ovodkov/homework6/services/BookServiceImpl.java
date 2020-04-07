package ru.otus.ovodkov.homework6.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework6.dao.BookDao;
import ru.otus.ovodkov.homework6.domain.Author;
import ru.otus.ovodkov.homework6.domain.Book;
import ru.otus.ovodkov.homework6.domain.Comment;
import ru.otus.ovodkov.homework6.domain.Genre;
import ru.otus.ovodkov.homework6.exceptions.NoEntityException;

import java.util.List;
import java.util.Set;

/**
 * @author Ovodkov Sergey on 07.04.2020
 * @see BookService
 */
@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookRepository;

    /**
     * @param idBook Идентификатор книги
     * @return Искомая книга
     * @throws NoEntityException
     * @see BookService#getBookById(long)
     */
    @Override
    public Book getBookById(long idBook) throws NoEntityException {
        return bookRepository
                .getByBookId(idBook)
                .orElseThrow(() -> new NoEntityException(idBook, Book.class.getName()));
    }

    /**
     * @return Получить список книг
     * @see BookService#getBooks()
     */
    @Override
    public List<Book> getBooks() {
        return bookRepository.getAllBooks();
    }

    /**
     * @param idBook Идентификатор книги
     * @throws NoEntityException
     * @see BookService#delete(long)
     */
    @Override
    public void delete(long idBook) throws NoEntityException {
        Book book = bookRepository
                .getByBookId(idBook)
                .orElseThrow(() -> new NoEntityException(idBook, Book.class.getName()));
        bookRepository.delete(book);
    }

    /**
     * @param idBook Идентификатор книги
     * @return Всех авторов указанной книги
     * @throws NoEntityException
     * @see BookService#getAuthorsBook(long)
     */
    @Override
    public Set<Author> getAuthorsBook(long idBook) throws NoEntityException {
        return bookRepository
                .getByBookId(idBook)
                .orElseThrow(() -> new NoEntityException(idBook, Book.class.getName()))
                .getAuthors();
    }

    /**
     * @param idBook Идентификатор книги
     * @return Список жанров книги
     * @throws NoEntityException
     * @see BookService#getGenresBook(long)
     */
    @Override
    public Set<Genre> getGenresBook(long idBook) throws NoEntityException {
        return bookRepository
                .getByBookId(idBook)
                .orElseThrow(() -> new NoEntityException(idBook, Book.class.getName()))
                .getGenres();
    }

    /**
     * @param idBook Идентификатор книги
     * @return Все комментарии к книги
     * @throws NoEntityException
     * @see BookService#getCommentsBook(long)
     */
    @Override
    public Set<Comment> getCommentsBook(long idBook) throws NoEntityException {
        return bookRepository
                .getByBookId(idBook)
                .orElseThrow(() -> new NoEntityException(idBook, Book.class.getName()))
                .getComments();
    }
}
