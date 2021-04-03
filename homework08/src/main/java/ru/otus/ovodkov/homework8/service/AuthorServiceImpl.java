package ru.otus.ovodkov.homework8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework8.document.Author;
import ru.otus.ovodkov.homework8.dto.BookDto;
import ru.otus.ovodkov.homework8.exceptions.NoDocumentException;
import ru.otus.ovodkov.homework8.repository.AuthorRepository;

import java.util.List;

/**
 * {@inheritDoc}
 *
 * @author Ovodkov Sergey
 * created on 19.08.2020
 */
@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<BookDto> getBooksAuthor(String authorId) throws NoDocumentException {
        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new NoDocumentException(authorId, Author.class.getName()));

        return author.getBooks();
    }
}
