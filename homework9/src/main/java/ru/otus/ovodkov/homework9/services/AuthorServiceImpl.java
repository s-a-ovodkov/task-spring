package ru.otus.ovodkov.homework9.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework9.exceptions.NoEntityException;
import ru.otus.ovodkov.homework9.model.Author;
import ru.otus.ovodkov.homework9.model.Book;
import ru.otus.ovodkov.homework9.repository.AuthorRepository;

import java.util.List;
import java.util.Set;

/**
 * Сервис работы с авторами книг
 *
 * @author Ovodkov Sergey
 * created on 26.04.2020
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
