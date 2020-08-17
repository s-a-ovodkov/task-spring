package ru.otus.ovodkov.homework8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework8.document.Book;
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
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }
}
