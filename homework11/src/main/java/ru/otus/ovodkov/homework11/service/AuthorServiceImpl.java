package ru.otus.ovodkov.homework11.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import ru.otus.ovodkov.homework11.document.Author;
import ru.otus.ovodkov.homework11.dto.BookDto;
import ru.otus.ovodkov.homework11.exceptions.NoDocumentException;
import ru.otus.ovodkov.homework11.repository.AuthorRepository;

import java.util.List;

/**
 * {@inheritDoc}
 *
 * @author Ovodkov Sergey
 * created on 15.09.2020
 */
@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Flux<Author> getAuthors() {
        return repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<BookDto> getBooksAuthor(String authorId) throws NoDocumentException {
        Author author = repository.findById(authorId).block();
        return author.getBooks();
    }
}
