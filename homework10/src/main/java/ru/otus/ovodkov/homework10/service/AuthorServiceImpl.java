package ru.otus.ovodkov.homework10.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework10.entity.Author;
import ru.otus.ovodkov.homework10.entity.Book;
import ru.otus.ovodkov.homework10.exception.NoEntityException;
import ru.otus.ovodkov.homework10.repository.AuthorRepository;

import java.util.List;
import java.util.Set;

/**
 * @author Ovodkov Sergey
 * created on 12.08.2020
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
    public Set<Book> getBooksAuthor(long idAuthor) {
        Author author = authorRepository
                .findByIdAuthor(idAuthor)
                .orElseThrow(() -> new NoEntityException(idAuthor, Author.class.getName()));
        return author.getBooks();
    }
}
